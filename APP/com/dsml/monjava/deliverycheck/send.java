package com.dsml.monjava.deliverycheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class send
  extends AppCompatActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131427361);
    paramBundle = (WebView)findViewById(2131296456);
    paramBundle.setWebViewClient(new WebViewClient());
    paramBundle.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    paramBundle.getSettings().setLoadWithOverviewMode(true);
    paramBundle.getSettings().setUseWideViewPort(true);
    paramBundle.getSettings().setSupportZoom(true);
    paramBundle.getSettings().setBuiltInZoomControls(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://osias.asuscomm.com/~post/searchmeweb.php?BIdentity=");
    localStringBuilder.append(LoginActivity.vaules[3]);
    paramBundle.loadUrl(localStringBuilder.toString());
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\send.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */