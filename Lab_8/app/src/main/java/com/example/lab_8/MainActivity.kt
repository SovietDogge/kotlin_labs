package com.example.lab_8

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Vertical RecyclerView
        binding.Vert.layoutManager = LinearLayoutManager(this)
        val brickData = listOf(
            Pair("Stone", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fru-m.org%2Fuploads%2Fposts%2F2014-11%2F1416047233_1402750092_2014-06-14_164310.png&f=1&nofb=1&ipt=ed9f2f9f83652ca746194454468799fa2c4f124e9a012037455a880c510bd848&ipo=images"),
            Pair("Diamond", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgamepedia.cursecdn.com%2Fminecraft_ru_gamepedia%2F2%2F27%2F%25D0%2590%25D0%25BB%25D0%25BC%25D0%25B0%25D0%25B7%25D0%25BD%25D1%258B%25D0%25B9_%25D0%25B1%25D0%25BB%25D0%25BE%25D0%25BA.png%3Fversion%3D8c2acb91f45700883998971e12cb5eb3&f=1&nofb=1&ipt=95f65c858735766675e91dc953ce13c20dcd2a73c2fefb5e88a0fe21fbd89ea3&ipo=images"),
            Pair("GOLD", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.wikia.nocookie.net%2Fminecraft_ru_gamepedia%2Fimages%2F4%2F45%2F%25D0%2597%25D0%25BE%25D0%25BB%25D0%25BE%25D1%2582%25D0%25BE%25D0%25B9_%25D0%25B1%25D0%25BB%25D0%25BE%25D0%25BA_JE6_BE3.png%2Frevision%2Flatest%3Fcb%3D20200518102227&f=1&nofb=1&ipt=11285948f72f89f87460896010b9ab2cc4c5ea8884722616fc7f58395237a2c8&ipo=images"),
            Pair("Hell stone", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgamepedia.cursecdn.com%2Fminecraft_ru_gamepedia%2Fe%2Fe7%2F%25D0%2590%25D0%25B4%25D1%2581%25D0%25BA%25D0%25B8%25D0%25B9_%25D0%25BA%25D0%25B0%25D0%25BC%25D0%25B5%25D0%25BD%25D1%258C.png&f=1&nofb=1&ipt=78867b86790f042a282672345ba27d1a11e020fc5b725d91a8fb176adb039efc&ipo=images"),
            Pair("Brick", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftula.moskeram.ru%2Fupload%2Fiblock%2Fe42%2Fe42f51a98045e019c6b83e753bb50592.png&f=1&nofb=1&ipt=4ab3da32824c4e79d799ef6947e12c4a5060800509847f97d1e5afc975256a8a&ipo=images"),
            Pair("Ground", ""),
            Pair("Cinder block", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.budblok.if.ua%2Fassets%2Fimages%2Fitems%2F4-IMG_2132.png&f=1&nofb=1&ipt=96ae6125164cf5e9668f9a782d861123bc3871f87fae36db0dae883cc7cf4c23&ipo=images"),
            Pair("Bentley", null),
        )
        val adapter = BlocksAdapter(brickData){ position: Int ->
            Toast.makeText(this, brickData[position].first, Toast.LENGTH_SHORT).show()
        }
        binding.Vert.adapter = adapter

        // Horizontal RecyclerView
        binding.Hor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val characterData = listOf(
            "Charlie",
            "Alastor",
            "Lucifer",
            "Angel",
            "Adam",
            "Moxxie",
            "Veggie",
            "Hasker"
        )
        val adapterSecond = HazbinAdapter(characterData)
        binding.Hor.adapter = adapterSecond

    }
}