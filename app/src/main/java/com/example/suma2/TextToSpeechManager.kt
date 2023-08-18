package com.example.suma2


import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TextToSpeechManager private constructor() {

    private lateinit var tts: TextToSpeech

    companion object {

        val instance = TextToSpeechManager()

        fun init(context: Context) {
            instance.tts = TextToSpeech(context) { status ->
                // check if initialization successful
                if (status != TextToSpeech.SUCCESS) {
                    throw Exception("Could not initialize.")
                }
            }
        }

    }

    fun speak(text: String, locale: Locale) {
        setLocaleAndSpeechRate(locale, 1.0f)
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    private fun setLocaleAndSpeechRate(locale: Locale, speechRate: Float) {
        if (tts.voice.locale != locale) {
            val languageStatus = tts.isLanguageAvailable(locale)
            if (languageStatus == TextToSpeech.LANG_MISSING_DATA
                || languageStatus == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                throw Exception("The language $locale is not supported.")
            }
        }

        tts.language = locale
        tts.setSpeechRate(speechRate)
    }

}