package cubex.mahesh.webview_dec7am

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
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

       // wview.webViewClient = WebViewClient()
        wview.settings.javaScriptEnabled = true
        wview.settings.builtInZoomControls = true

        val  pDialog = ProgressDialog(this@MainActivity)
        pDialog.setTitle("Message")
        pDialog.setMessage("Please wait page is loading...")
        pDialog.setCancelable(false)

        wview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pDialog.show()
            }
             override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                 pDialog.dismiss()
            }

            override fun shouldOverrideUrlLoading(view: WebView?,
                                request: WebResourceRequest?): Boolean {

                Toast.makeText(this@MainActivity,
                    view!!.url,Toast.LENGTH_LONG).show()

                return super.shouldOverrideUrlLoading(view, request)
            }

        }


    } // onCreate( )

    override fun onClick(v: View?) {
        if(v!=null)
        when(v.id){
            R.id.search -> {
                if(et1.text.toString().startsWith("http://",
                        false)){
                    wview.loadUrl(et1.text.toString())
                }else{
                    wview.loadUrl("http://"+et1.text.toString())
                }
               }
            R.id.fb -> { wview.loadUrl("http://www.facebook.com") }
            R.id.google -> { wview.loadUrl("http://www.google.com")}
            R.id.you->{wview.loadUrl("http://www.youtube.com") }
            R.id.html-> { }
        }


    }

}
