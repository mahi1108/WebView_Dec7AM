package cubex.mahesh.webview_dec7am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener (this@MainActivity)
        fb.setOnClickListener(this@MainActivity)
        google.setOnClickListener(this@MainActivity)
        you.setOnClickListener(this@MainActivity)
        html.setOnClickListener(this@MainActivity)
    }

    override fun onClick(v: View?) {
        if(v!=null)
        when(v.id){
            R.id.search -> { wview.loadUrl(et1.text.toString())}
            R.id.fb -> { wview.loadUrl("http://www.facebook.com") }
            R.id.google -> { wview.loadUrl("http://www.google.com")}
            R.id.you->{wview.loadUrl("http://www.youtube.com") }
            R.id.html-> { }
        }


    }

}
