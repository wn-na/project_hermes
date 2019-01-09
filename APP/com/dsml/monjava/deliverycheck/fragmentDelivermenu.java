package com.dsml.monjava.deliverycheck;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class fragmentDelivermenu
  extends Fragment
{
  private String[] Delivery;
  private String boxnum = "0";
  private int count;
  private String htmllists;
  private Button open;
  private Button open2;
  private Button open3;
  private String products;
  private TextView text;
  private TextView text2;
  private TextView text3;
  private String waybil;
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131427379, paramViewGroup, false);
    this.open = ((Button)paramLayoutInflater.findViewById(2131296263));
    this.open2 = ((Button)paramLayoutInflater.findViewById(2131296264));
    this.open3 = ((Button)paramLayoutInflater.findViewById(2131296265));
    this.text = ((TextView)paramLayoutInflater.findViewById(2131296404));
    this.text2 = ((TextView)paramLayoutInflater.findViewById(2131296405));
    this.text3 = ((TextView)paramLayoutInflater.findViewById(2131296406));
    paramViewGroup = (Button)paramLayoutInflater.findViewById(2131296257);
    paramBundle = (Button)paramLayoutInflater.findViewById(2131296428);
    this.text.setVisibility(8);
    this.text2.setVisibility(8);
    this.text3.setVisibility(8);
    this.open.setVisibility(8);
    this.open2.setVisibility(8);
    this.open3.setVisibility(8);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentDelivermenu.JsoupAsyncTaskSEND_LIST(fragmentDelivermenu.this, null).execute(new Void[0]);
      }
    });
    this.open.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentDelivermenu.JsoupAsyncTaskOPEN1(fragmentDelivermenu.this, null).execute(new Void[0]);
      }
    });
    this.open2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentDelivermenu.JsoupAsyncTaskOPEN2(fragmentDelivermenu.this, null).execute(new Void[0]);
      }
    });
    this.open3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentDelivermenu.JsoupAsyncTaskOPEN3(fragmentDelivermenu.this, null).execute(new Void[0]);
      }
    });
    paramViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentDelivermenu.JsoupAsyncTaskclosedeliver(fragmentDelivermenu.this, null).execute(new Void[0]);
        new fragmentDelivermenu.JsoupAsyncTaskSEND_LIST(fragmentDelivermenu.this, null).execute(new Void[0]);
      }
    });
    return paramLayoutInflater;
  }
  
  private class JsoupAsyncTaskOPEN1
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskOPEN1() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/changeopendriver.php?BOXnumb=");
        paramVarArgs.append(fragmentDelivermenu.this.Delivery[4]);
        paramVarArgs.append("&usercode=");
        paramVarArgs.append(LoginActivity.userid);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentDelivermenu.access$502(fragmentDelivermenu.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (fragmentDelivermenu.this.htmllists.equals("True"))
      {
        paramVoid = fragmentDelivermenu.this.getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[4]);
        localStringBuilder.append("에 해당하는 보관함을 오픈합니다.");
        Toast.makeText(paramVoid, localStringBuilder.toString(), 1).show();
        fragmentDelivermenu.access$1402(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[2]);
        fragmentDelivermenu.access$1502(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[3]);
        fragmentDelivermenu.access$1602(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[4]);
        return;
      }
      Toast.makeText(fragmentDelivermenu.this.getActivity(), "ERROR", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskOPEN2
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskOPEN2() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/changeopendriver.php?BOXnumb=");
        paramVarArgs.append(fragmentDelivermenu.this.Delivery[11]);
        paramVarArgs.append("&usercode=");
        paramVarArgs.append(LoginActivity.userid);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentDelivermenu.access$502(fragmentDelivermenu.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (fragmentDelivermenu.this.htmllists.equals("True"))
      {
        paramVoid = fragmentDelivermenu.this.getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[11]);
        localStringBuilder.append("에 해당하는 보관함을 오픈합니다.");
        Toast.makeText(paramVoid, localStringBuilder.toString(), 1).show();
        fragmentDelivermenu.access$1402(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[9]);
        fragmentDelivermenu.access$1502(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[10]);
        fragmentDelivermenu.access$1602(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[11]);
        return;
      }
      Toast.makeText(fragmentDelivermenu.this.getActivity(), "ERROR", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskOPEN3
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskOPEN3() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/changeopendriver.php?BOXnumb=");
        paramVarArgs.append(fragmentDelivermenu.this.Delivery[18]);
        paramVarArgs.append("&usercode=");
        paramVarArgs.append(LoginActivity.userid);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentDelivermenu.access$502(fragmentDelivermenu.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (fragmentDelivermenu.this.htmllists.equals("True"))
      {
        paramVoid = fragmentDelivermenu.this.getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[18]);
        localStringBuilder.append("에 해당하는 보관함을 오픈합니다.");
        Toast.makeText(paramVoid, localStringBuilder.toString(), 1).show();
        fragmentDelivermenu.access$1402(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[16]);
        fragmentDelivermenu.access$1502(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[17]);
        fragmentDelivermenu.access$1602(fragmentDelivermenu.this, fragmentDelivermenu.this.Delivery[18]);
        return;
      }
      Toast.makeText(fragmentDelivermenu.this.getActivity(), "ERROR", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskSEND_LIST
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskSEND_LIST() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/sendyou_process.php?DIdentity=");
        paramVarArgs.append(LoginActivity.vaules[4]);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentDelivermenu.access$502(fragmentDelivermenu.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      fragmentDelivermenu.access$602(fragmentDelivermenu.this, fragmentDelivermenu.this.htmllists.split("/"));
      fragmentDelivermenu.this.text.setVisibility(8);
      fragmentDelivermenu.this.text2.setVisibility(8);
      fragmentDelivermenu.this.text3.setVisibility(8);
      fragmentDelivermenu.this.open.setVisibility(8);
      fragmentDelivermenu.this.open2.setVisibility(8);
      fragmentDelivermenu.this.open3.setVisibility(8);
      int i = 0;
      while (fragmentDelivermenu.this.Delivery[i] != null)
      {
        if (fragmentDelivermenu.this.Delivery[i].equals("return"))
        {
          fragmentDelivermenu.access$1302(fragmentDelivermenu.this, i);
          break;
        }
        i += 7;
      }
      StringBuilder localStringBuilder;
      if ((fragmentDelivermenu.this.count > 0) && (!fragmentDelivermenu.this.Delivery[0].equals("return")))
      {
        paramVoid = fragmentDelivermenu.this.text;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[3]);
        localStringBuilder.append("\n");
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[4]);
        paramVoid.setText(localStringBuilder.toString());
        fragmentDelivermenu.this.text.setVisibility(0);
        fragmentDelivermenu.this.open.setVisibility(0);
      }
      if ((fragmentDelivermenu.this.count - 6 > 0) && (!fragmentDelivermenu.this.Delivery[7].equals("return")))
      {
        paramVoid = fragmentDelivermenu.this.text2;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[10]);
        localStringBuilder.append("\n");
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[11]);
        paramVoid.setText(localStringBuilder.toString());
        fragmentDelivermenu.this.text2.setVisibility(0);
        fragmentDelivermenu.this.open2.setVisibility(0);
      }
      if ((fragmentDelivermenu.this.count - 12 > 0) && (!fragmentDelivermenu.this.Delivery[14].equals("return")))
      {
        paramVoid = fragmentDelivermenu.this.text3;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[17]);
        localStringBuilder.append("\n");
        localStringBuilder.append(fragmentDelivermenu.this.Delivery[18]);
        paramVoid.setText(localStringBuilder.toString());
        fragmentDelivermenu.this.text3.setVisibility(0);
        fragmentDelivermenu.this.open3.setVisibility(0);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskclosedeliver
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskclosedeliver() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/receive.php?waybill=");
        paramVarArgs.append(fragmentDelivermenu.this.waybil);
        paramVarArgs.append("&boxID=");
        paramVarArgs.append(fragmentDelivermenu.this.boxnum);
        paramVarArgs.append("&UserID=");
        paramVarArgs.append(LoginActivity.userid);
        paramVarArgs.append("&product=");
        paramVarArgs.append(fragmentDelivermenu.this.products);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentDelivermenu.access$502(fragmentDelivermenu.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (fragmentDelivermenu.this.htmllists.equals("True/"))
      {
        Toast.makeText(fragmentDelivermenu.this.getActivity(), "보관함을 닫습니다.", 1).show();
        return;
      }
      Toast.makeText(fragmentDelivermenu.this.getActivity(), "에러가 발생했습니다. 잠시후에 다시 시도해 주세요", 1).show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\fragmentDelivermenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */