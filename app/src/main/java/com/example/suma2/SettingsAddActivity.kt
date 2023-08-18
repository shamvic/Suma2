package com.example.suma2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView

class SettingsAddActivity : AppCompatActivity() {

    private lateinit var tvNumbers: TextView
    private lateinit var tvSeconds: TextView
    private var newNumSequence:Int=6
    private var newNumSeconds:Int=8
    private var swNumDigOn:Boolean=false
    private lateinit var btnSettingsDone: Button
    private lateinit var btnSettingsCancel: Button
    private lateinit var swNumDig:Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_add)
        supportActionBar?.title = "Sumar Setting"
        initComponents()
        setUpSeekBarNum()
        setUpSeekBarSeconds()
        btnSettingsDone.setOnClickListener() { navigateToSettingsDone() }
        btnSettingsCancel.setOnClickListener() { navigateToSettingsCancel() }
        swNumDig.setOnClickListener(){navigateToSetNumbersDigitals()        }
    }

    private fun navigateToSetNumbersDigitals() {
        if (swNumDig.isChecked) {
            swNumDigOn = true
            Log.d("AddTimer"," SwitchON position1 = $swNumDigOn")
        }
        else swNumDigOn=false
    }

    private fun navigateToSettingsCancel() {
        val i = Intent()

        setResult(RESULT_CANCELED,i)
        finish()
    }

    private fun navigateToSettingsDone() {
        Log.d("AddTimer"," Numero sequencia a enviar= $newNumSequence")
        Log.d("AddTimer"," Segundos a enviar = $newNumSeconds")
        Log.d("AddTimer"," SwitchON = $swNumDigOn")
        val i = Intent()
        //i.putExtra("numbers", newNumSequence)
        i.putExtra("numbers",newNumSequence)
        i.putExtra("seconds", newNumSeconds)
        i.putExtra("switch", swNumDigOn)
        setResult(RESULT_OK,i)
        finish()
    }

    private fun setUpSeekBarNum() {
        val seekBarNum: SeekBar =findViewById(R.id.seekBarNum)
        tvNumbers=findViewById(R.id.tvNumbers)
        //seekBarNum.setProgress(4)

        seekBarNum.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvNumbers.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar!=null) newNumSequence=seekBar.progress

                Log.d("AddTimer"," Numero sequencia= $newNumSequence")
            }

        })
    }

    private fun setUpSeekBarSeconds() {
        val seekBarSeconds: SeekBar =findViewById(R.id.seekBarSeconds)
        tvSeconds=findViewById(R.id.tvSeconds)
        //seekBarSeconds.setProgress(9)

        seekBarSeconds.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvSeconds.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar!=null) newNumSeconds=seekBar.progress

                Log.d("AddTimer"," Segundos = $newNumSeconds")
            }

        })
    }

    private fun initComponents(){
        btnSettingsDone = findViewById(R.id.btnSettingsDone)
        btnSettingsCancel= findViewById(R.id.btnSettingsCancel)
        swNumDig=findViewById(R.id.swNumDig)
    }
}