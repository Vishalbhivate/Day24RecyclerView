package com.example.day24recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecycerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        myRecycerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.pirpic1,
            R.drawable.ekpic2,
            R.drawable.donpic4,
            R.drawable.tabupic3,
            R.drawable.stockpic,
            R.drawable.asapic6,

        )

        val newsHeadingArray = arrayOf(
            "Priyanka Gandhi Vadra takes oath as MP in Lok Sabha after winning Wayanad bypoll",
            "Key takeaways from Eknath Shinde's message as decks cleared for BJP CM",
            "Mexico warns Trump tariffs would kill 400,000 US jobs, threatens retaliation",
            "Tabu reveals when she’ll make her debut on Dune Prophecy, shares new look as Sister Francesca from HBO show: ‘Queen is coming’",
            "FPIs pour Rs 11,113 cr into Indian stock market in 3 days after Rs 1.55 lakh cr sell-off since Oct",
            "‘1,000 Kukis from Manipur came here’: In Assam’s Karbi Anglong, new claim and new row"
        )

        val newsContent = arrayOf(
           getString(R.string.news_content), getString(R.string.news_content2), getString(R.string.news_content3),
            getString(R.string.news_content4), getString(R.string.news_content5), getString(R.string.news_content6)
        )

        // to set hav bhav of items inside recyclerview, yertcially, horizontally, uniform grid
          myRecycerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList,this)
        myRecycerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
               // on clicking each item , what action do you want perfore

                val intent = Intent(applicationContext, NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newscontent",newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })


    }
}