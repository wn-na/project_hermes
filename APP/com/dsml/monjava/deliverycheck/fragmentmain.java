package com.dsml.monjava.deliverycheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class fragmentmain
  extends Fragment
{
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131427355, paramViewGroup, false);
    paramViewGroup = (Button)paramLayoutInflater.findViewById(2131296455);
    paramBundle = (Button)paramLayoutInflater.findViewById(2131296442);
    Button localButton1 = (Button)paramLayoutInflater.findViewById(2131296458);
    Button localButton2 = (Button)paramLayoutInflater.findViewById(2131296378);
    WebView localWebView = (WebView)paramLayoutInflater.findViewById(2131296515);
    if (LoginActivity.vaules[2].equals("1"))
    {
      localWebView.setVisibility(8);
    }
    else
    {
      localButton1.setVisibility(8);
      localWebView.setWebViewClient(new WebViewClient());
      localWebView.getSettings().setLoadWithOverviewMode(true);
      localWebView.getSettings().setUseWideViewPort(true);
      localWebView.loadUrl("http://osias.asuscomm.com/~post/logo.jpg");
    }
    paramViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(fragmentmain.this.getActivity(), send.class);
        fragmentmain.this.getActivity().startActivity(paramAnonymousView);
      }
    });
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(fragmentmain.this.getActivity(), search.class);
        fragmentmain.this.getActivity().startActivity(paramAnonymousView);
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(fragmentmain.this.getActivity(), log.class);
        fragmentmain.this.getActivity().startActivity(paramAnonymousView);
      }
    });
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(fragmentmain.this.getActivity(), sendyou.class);
        fragmentmain.this.getActivity().startActivity(paramAnonymousView);
      }
    });
    return paramLayoutInflater;
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\fragmentmain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */