package sample.sainttropez

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.email
import org.jetbrains.anko.sendSMS
import org.jetbrains.anko.share

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(imageView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.top -> {
                imageView.setImageResource(R.drawable.toppage)
                return true
            }
            R.id.lunch01 -> {
                imageView.setImageResource(R.drawable.lunch01)
                return true
            }
            R.id.lunch02 -> {
                imageView.setImageResource(R.drawable.lunch02)
                return true
            }
            R.id.dinner01 -> {
                imageView.setImageResource(R.drawable.dinner01)
                return true
            }
            R.id.dinner02 -> {
                imageView.setImageResource(R.drawable.dinner02)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.sms -> sendSMS("999-9999-9999")
            R.id.mail -> email("hoge@example.com", "問い合わせ", "予約希望いたします。")
            R.id.share -> share("レストランを紹介")
            R.id.browse -> browse("https://www.yahoo.co.jp")
            else -> super.onContextItemSelected(item)
        }
    }
}
