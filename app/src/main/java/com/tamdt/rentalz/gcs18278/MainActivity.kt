package com.tamdt.rentalz.gcs18278

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.tamdt.rentalz.gcs18278.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var mLayoutBinding: ActivityMainBinding

    // reporter name
    private var mIsReporterNameValid: Boolean? = null
    private val mReporterNameTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val homeName = s.toString().trim()
            mIsReporterNameValid = homeName.isNotEmpty()
            mLayoutBinding.tvReporterNameError.visibility = View.VISIBLE
            mLayoutBinding.tvReporterNameError.text =
                if (!mIsReporterNameValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // home name
    private var mIsHomeNameValid: Boolean? = null
    private val mHomeNameTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val homeName = s.toString().trim()
            mIsHomeNameValid = homeName.isNotEmpty()
            mLayoutBinding.tvHomeNameError.visibility = View.VISIBLE
            mLayoutBinding.tvHomeNameError.text =
                if (!mIsHomeNameValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // street
    private var mIsStreetValid: Boolean? = null
    private val mStreetTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val street = s.toString().trim()
            mIsStreetValid = street.isNotEmpty()
            mLayoutBinding.tvStreetError.visibility = View.VISIBLE
            mLayoutBinding.tvStreetError.text =
                if (!mIsStreetValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // ward
    private var mIsWardValid: Boolean? = null
    private val mWardTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsWardValid = ward.isNotEmpty()
            mLayoutBinding.tvWardError.visibility = View.VISIBLE
            mLayoutBinding.tvWardError.text =
                if (!mIsWardValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // district
    private var mIsDistrictValid: Boolean? = null
    private val mDistrictTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsDistrictValid = ward.isNotEmpty()
            mLayoutBinding.tvDistrictError.visibility = View.VISIBLE
            mLayoutBinding.tvDistrictError.text =
                if (!mIsDistrictValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // city
    private var mIsCityValid: Boolean? = null
    private val mCityTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsCityValid = ward.isNotEmpty()
            mLayoutBinding.tvCityError.visibility = View.VISIBLE
            mLayoutBinding.tvCityError.text =
                if (!mIsCityValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // furniture type
    private var mIsFurnitureTypeValid: Boolean? = null
    private val mFurnitureTypeTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsFurnitureTypeValid = ward.isNotEmpty()
            mLayoutBinding.tvFurnitureTypeError.visibility = View.VISIBLE
            mLayoutBinding.tvFurnitureTypeError.text =
                if (!mIsFurnitureTypeValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // house type
    private var mIsHouseTypeValid: Boolean? = null
    private val mHouseTypeTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsHouseTypeValid = ward.isNotEmpty()
            mLayoutBinding.tvHouseTypeError.visibility = View.VISIBLE
            mLayoutBinding.tvHouseTypeError.text =
                if (!mIsHouseTypeValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // number of room
    private var mIsNoRoomValid: Boolean? = null
    private val mNoRoomTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsNoRoomValid = ward.isNotEmpty()
            mLayoutBinding.tvNoRoomError.visibility = View.VISIBLE
            mLayoutBinding.tvNoRoomError.text =
                if (!mIsNoRoomValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // price
    private var mIsPriceValid: Boolean? = null
    private val mPriceTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mIsPriceValid = ward.isNotEmpty()
            mLayoutBinding.tvPriceError.visibility = View.VISIBLE
            mLayoutBinding.tvPriceError.text =
                if (!mIsPriceValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }

    // notes
    private var mNotesValid: Boolean? = null
    private val mNotesTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            val ward = s.toString().trim()
            mNotesValid = ward.isNotEmpty()
            mLayoutBinding.tvDescriptionError.visibility = View.VISIBLE
            mLayoutBinding.tvDescriptionError.text =
                if (!mNotesValid!!) baseContext.getString(R.string.error_text) else ""
            enableButton()
        }
    }
    // created_at

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLayoutBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mLayoutBinding.root)
//        handleAnimation()
        setupTextWatcher()

        mLayoutBinding.cvLogin.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun enableButton() {
        mLayoutBinding.cvLogin.isEnabled =
            mIsHomeNameValid ?: false
                    && mIsStreetValid ?: false
                    && mIsReporterNameValid ?: false
                    && mIsWardValid ?: false
                    && mIsDistrictValid ?: false
                    && mIsCityValid ?: false
                    && mIsFurnitureTypeValid ?: false
                    && mIsHouseTypeValid ?: false
                    && mIsNoRoomValid ?: false
                    && mIsPriceValid ?: false
    }

    private fun setupTextWatcher() {
        mLayoutBinding.etReporterName.addTextChangedListener(mReporterNameTextWatcher)
        mLayoutBinding.etHomeName.addTextChangedListener(mHomeNameTextWatcher)
        mLayoutBinding.etStreet.addTextChangedListener(mStreetTextWatcher)
        mLayoutBinding.etWard.addTextChangedListener(mWardTextWatcher)
        mLayoutBinding.etDistrict.addTextChangedListener(mDistrictTextWatcher)
        mLayoutBinding.etCity.addTextChangedListener(mCityTextWatcher)
        mLayoutBinding.etFurnitureType.addTextChangedListener(mFurnitureTypeTextWatcher)
        mLayoutBinding.etHouseType.addTextChangedListener(mHouseTypeTextWatcher)
        mLayoutBinding.etNoRoom.addTextChangedListener(mNoRoomTextWatcher)
        mLayoutBinding.etPrice.addTextChangedListener(mPriceTextWatcher)
//        mLayoutBinding.etDescription.addTextChangedListener(mPasswordTextWatcher)
    }

    private fun showCustomDialog() {
        val builder1: AlertDialog.Builder = AlertDialog.Builder(this)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formatted = current.format(formatter)

        builder1.setMessage("Reporter name: ${mLayoutBinding.etReporterName.text.toString()} " +
                "\nHome name: ${mLayoutBinding.etHomeName.text.toString()} " +
                "\nAddress: ${mLayoutBinding.etStreet.text.toString()}, " +
                "${mLayoutBinding.etWard.text.toString()}, " +
                "${mLayoutBinding.etDistrict.text.toString()}, " +
                "${mLayoutBinding.etCity.text.toString()} " +
                "\nFurniture type: ${mLayoutBinding.etFurnitureType.text.toString()}" +
                "\nHouse type: ${mLayoutBinding.etHouseType.text.toString()}" +
                "\nNumber of rooms: ${mLayoutBinding.etNoRoom.text.toString()}" +
                "\nRent price: ${mLayoutBinding.etPrice.text.toString()}" +
                "\nNotes: ${mLayoutBinding.etDescription.text.toString()}" +
                "\nCreated at:  $formatted")
        builder1.setCancelable(true)

        builder1.setPositiveButton(
            "Yes",
            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        builder1.setNegativeButton(
            "No",
            DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alert11: AlertDialog = builder1.create()
        alert11.show()
    }
}