package com.example.fetchrewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
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

        val tableView: TableLayout = this.findViewById(R.id.dataView)

        val job = retrieveFromURL(url)

        runBlocking {
            job.join()

            var dfModified = modifyDataFrame(df)

            for(r in dfModified) {
                var row = TableRow(this@MainActivity)
                var idCol = TextView(this@MainActivity)
                var listIdCol = TextView(this@MainActivity)
                var nameCol = TextView(this@MainActivity)
                var id = r[0].toString()
                var listId = r[1].toString()
                var name = r[2].toString()
                idCol.text = id
                listIdCol.text = listId
                nameCol.text = name
                row.addView(idCol)
                row.addView(listIdCol)
                row.addView(nameCol)
                tableView.addView(row)
            }
        }
    }

    private fun retrieveFromURL(url: String) = scope.launch {
        df = DataFrame.readJson(url)
    }

    private fun modifyDataFrame(df: AnyFrame) : AnyFrame {
        var dfModified = df.drop { it["name"] == null || it["name"] == "" }

        dfModified = dfModified.sortBy { "listId" and "id" }

        return dfModified
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}