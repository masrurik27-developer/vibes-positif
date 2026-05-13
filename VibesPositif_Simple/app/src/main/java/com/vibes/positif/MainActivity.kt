package com.vibes.positif

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvGreeting   = findViewById<TextView>(R.id.tvGreeting)
        val tvAffirmation = findViewById<TextView>(R.id.tvAffirmation)

        tvGreeting.text = buildGreeting()
        tvAffirmation.text = getDailyAffirmation()
    }

    private fun buildGreeting(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 5..10  -> "🌅 Selamat Pagi!"
            in 11..14 -> "☀️ Selamat Siang!"
            in 15..17 -> "🌤 Selamat Sore!"
            else      -> "🌙 Selamat Malam!"
        }
    }

    private fun getDailyAffirmation(): String {
        val affirmations = listOf(
            "✨ Aku selalu menarik rezeki yang baik ke hidupku",
            "💪 Aku percaya diri dan berani menghadapi hari ini",
            "🌟 Aku layak mendapatkan semua hal baik di dunia",
            "❤️ Hatiku penuh dengan kebahagiaan dan rasa syukur",
            "🙏 Pintu rezeki selalu terbuka lebar untukku",
            "💙 Aku dicintai dan aku mencintai diriku sendiri",
            "🌈 Setiap hari hidupku semakin baik dan indah",
            "⭐ Pikiranku positif dan menarik hal-hal baik",
            "🎯 Aku fokus pada hal baik dan rezeki mengalir deras",
            "🌸 Aku damai, bahagia, dan penuh syukur hari ini"
        )
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return affirmations[dayOfYear % affirmations.size]
    }
}
