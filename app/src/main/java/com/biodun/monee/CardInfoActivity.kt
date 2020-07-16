package com.biodun.monee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.text.isDigitsOnly
import com.biodun.core.result.Failure
import com.biodun.monee.textRecognition.OcrActivity
import com.biodun.presentation.ViewState
import com.biodun.presentation.model.CardInfo
import com.biodun.presentation.viewmodel.CardInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_card_info.*

const val CARD_NUMBER_DIGITS = 6
const val REQUEST_CODE = 13
const val FIRST_DIGIT_POS = 0
const val FOURTH_DIGIT_POS = 3
const val FIFTH_DIGIT_POS = 4
const val SIXTH_DIGIT_POS = 5
@AndroidEntryPoint
class CardInfoActivity : AppCompatActivity() {

    private val cardInfoViewModel: CardInfoViewModel by viewModels()
    private val owner = { lifecycle }
    private var cardNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)
        observeCardInfoLiveData()
        configureView()
        handleCameraFabClick()
    }

    private fun configureView() {
        checkCardInfoButton.setOnClickListener { checkButton ->
            cardNumber = cardNumberEditText.text.toString()
            cardNumber.let {
                if (cardNumber.length == CARD_NUMBER_DIGITS && checkButton.isEnabled) {
                    cardInfoViewModel.getCardInfo(cardNumber)
                    (checkButton as Button).deactivate(R.drawable.view_deactivated_button_background)
                }
            }
        }
    }

    private fun observeCardInfoLiveData() {
        cardInfoViewModel.cardInfoLiveData.observe(owner) { viewState ->
            when(viewState) {
                is ViewState.Loading -> handleLoadingCardInfoState()
                is ViewState.Success -> handleCardInfoSuccessState(viewState.data)
                is ViewState.Error -> handleCardInfoErrorState(viewState.error)
            }
        }
    }

    private fun handleLoadingCardInfoState() {
        failureText.gone()
        cardLayout.inVisible()
        loadingBar.visible()
    }

    private fun handleCardInfoSuccessState(data: CardInfo) {
        loadingBar.gone()
        cardLayout.visible()
        failureText.gone()
        cardBankTextValue.text = data.bank.bankName.toUpperCase()
        cardBrandTextValue.text = data.cardBrand.toUpperCase()
        cardTypeTextValue.text = data.cardType.toUpperCase()
        countryTextValue.text = data.country.countryName.toUpperCase()
        cardNumberText.text =
            getString(R.string.cardNumber,
                cardNumber.substring(FIRST_DIGIT_POS..FOURTH_DIGIT_POS),
                cardNumber.substring(FIFTH_DIGIT_POS..SIXTH_DIGIT_POS)
            )
        (checkCardInfoButton as Button).activate(R.drawable.view_button_background)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val returnedText = data?.getStringExtra(OcrActivity.CARD_NUMBER_TEXT)
            returnedText?.let { returnedCardNumber ->
                if (returnedCardNumber.length == CARD_NUMBER_DIGITS && returnedCardNumber.isDigitsOnly()) {
                    cardNumberEditText.setText(returnedCardNumber)
                } else {
                    Toast.makeText(this,
                        "Text has to be number and 6 digits",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun handleCardInfoErrorState(failure: Failure) {
        loadingBar.gone()
        failureText.visible()
        failureText.text = when(failure) {
            is Failure.NotFoundFailure -> getString(R.string.no_card_info)
            is Failure.ServerFailure -> getString(R.string.server_failure)
            is Failure.TimeoutFailure -> getString(R.string.timeout_failure)
            is Failure.NoInternetFailure -> getString(R.string.no_internet_failure)
        }
        (checkCardInfoButton as Button).activate(R.drawable.view_button_background)
    }

    private fun handleCameraFabClick() {
        cameraFab.setOnClickListener {
            startActivityForResult(
                Intent(this, OcrActivity::class.java), REQUEST_CODE
            )
        }
    }
}
