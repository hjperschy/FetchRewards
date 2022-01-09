package com.example.fetchrewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import kotlinx.coroutines.*

import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.drop
import org.jetbrains.kotlinx.dataframe.api.sortBy
import org.jetbrains.kotlinx.dataframe.io.readJson

class MainActivity : AppCompatActivity() {

    private val url: String = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    private val scope = CoroutineScope(Dispatchers.Default)

    private var df: AnyFrame = DataFrame.Empty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = this.findViewById(R.id.dataView)

        val job = retrieveFromURL(url)

        runBlocking {
            job.join()

            var dfModified = modifyDataFrame(df)

            var test: String = dfModified.columnsCount().toString()

            textView.text = test
        }
    }

    private fun retrieveFromURL(url: String) = scope.launch {
        df = DataFrame.readJson(url)
    }

    private fun modifyDataFrame(df: AnyFrame) : AnyFrame {
        df.drop { it["name"] == null || it["name"] == "" }

        df.sortBy { "listId" and "name" }

        return df
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}