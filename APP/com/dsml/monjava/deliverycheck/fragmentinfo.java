package com.dsml.monjava.deliverycheck;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class fragmentinfo
  extends Fragment
{
  public static String[] INFO;
  private String getHtmlContentInStringFormat;
  private TextView getdelivername;
  private TextView getendpoint;
  private TextView getendtime;
  private TextView getgetter;
  private TextView getgiver;
  private TextView getname;
  private TextView getsendtime;
  private String htmlContentInStringFormat;
  private EditText postnumber;
  public String[] vaules;
  
  private boolean check()
  {
    return !this.postnumber.getText().toString().equals("");
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable final ViewGroup paramViewGroup, @Nullable final Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131427380, paramViewGroup, false);
    this.postnumber = ((EditText)paramLayoutInflater.findViewById(2131296413));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131296412);
    paramBundle = (TextView)paramLayoutInflater.findViewById(2131296358);
    final TextView localTextView1 = (TextView)paramLayoutInflater.findViewById(2131296336);
    final TextView localTextView2 = (TextView)paramLayoutInflater.findViewById(2131296356);
    final TextView localTextView3 = (TextView)paramLayoutInflater.findViewById(2131296322);
    final TextView localTextView4 = (TextView)paramLayoutInflater.findViewById(2131296457);
    final TextView localTextView5 = (TextView)paramLayoutInflater.findViewById(2131296337);
    this.getname = ((TextView)paramLayoutInflater.findViewById(2131296354));
    this.getgiver = ((TextView)paramLayoutInflater.findViewById(2131296353));
    this.getendpoint = ((TextView)paramLayoutInflater.findViewById(2131296350));
    this.getgetter = ((TextView)paramLayoutInflater.findViewById(2131296352));
    this.getdelivername = ((TextView)paramLayoutInflater.findViewById(2131296349));
    this.getsendtime = ((TextView)paramLayoutInflater.findViewById(2131296355));
    this.getendtime = ((TextView)paramLayoutInflater.findViewById(2131296351));
    this.getname.setMovementMethod(new ScrollingMovementMethod());
    Button localButton = (Button)paramLayoutInflater.findViewById(2131296268);
    paramViewGroup.setVisibility(8);
    paramBundle.setVisibility(8);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
    localTextView3.setVisibility(8);
    localTextView4.setVisibility(8);
    localTextView5.setVisibility(8);
    this.getname.setVisibility(8);
    this.getgiver.setVisibility(8);
    this.getendpoint.setVisibility(8);
    this.getgetter.setVisibility(8);
    this.getdelivername.setVisibility(8);
    this.getsendtime.setVisibility(8);
    this.getendtime.setVisibility(8);
    this.getdelivername.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new fragmentinfo.JsoupAsyncTaskINFO(fragmentinfo.this, null).execute(new Void[0]);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (fragmentinfo.this.check())
        {
          paramViewGroup.setVisibility(0);
          paramBundle.setVisibility(0);
          localTextView1.setVisibility(0);
          localTextView2.setVisibility(0);
          localTextView3.setVisibility(0);
          localTextView4.setVisibility(0);
          localTextView5.setVisibility(0);
          fragmentinfo.this.getname.setVisibility(0);
          fragmentinfo.this.getgiver.setVisibility(0);
          fragmentinfo.this.getendpoint.setVisibility(0);
          fragmentinfo.this.getgetter.setVisibility(0);
          fragmentinfo.this.getdelivername.setVisibility(0);
          fragmentinfo.this.getsendtime.setVisibility(0);
          fragmentinfo.this.getendtime.setVisibility(0);
          new fragmentinfo.JsoupAsyncTaskSearch(fragmentinfo.this, null).execute(new Void[0]);
          return;
        }
        new AlertDialog.Builder(fragmentinfo.this.getActivity()).setMessage("입력한 값이 존재하지 않습니다!").setNegativeButton("확인", null).create().show();
      }
    });
    return paramLayoutInflater;
  }
  
  private class JsoupAsyncTaskINFO
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskINFO() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/driversearchapp.php?Driver=");
        paramVarArgs.append(fragmentinfo.this.vaules[5]);
        paramVarArgs.append("&DriverID=");
        paramVarArgs.append(fragmentinfo.this.vaules[6]);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        fragmentinfo.access$1202(fragmentinfo.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      fragmentinfo.INFO = fragmentinfo.this.getHtmlContentInStringFormat.split("/");
      paramVoid = new AlertDialog.Builder(fragmentinfo.this.getActivity());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("이름 : ");
      localStringBuilder.append(fragmentinfo.INFO[0]);
      localStringBuilder.append("\n소속 : ");
      localStringBuilder.append(fragmentinfo.INFO[1]);
      localStringBuilder.append("\n전화번호 : ");
      localStringBuilder.append(fragmentinfo.INFO[2]);
      paramVoid.setMessage(localStringBuilder.toString()).setNegativeButton("확인", null).create().show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskSearch
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskSearch() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = fragmentinfo.this.postnumber.getText().toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("http://osias.asuscomm.com/~post/waybillsearch_process.php?Waybill=");
        localStringBuilder.append(paramVarArgs);
        paramVarArgs = Jsoup.connect(localStringBuilder.toString()).method(Connection.Method.GET).execute().parse();
        fragmentinfo.access$1102(fragmentinfo.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      fragmentinfo.this.vaules = fragmentinfo.this.htmlContentInStringFormat.split("/");
      if (fragmentinfo.this.vaules[0].equals("False"))
      {
        paramVoid = new AlertDialog.Builder(fragmentinfo.this.getActivity());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(fragmentinfo.this.postnumber.getText().toString());
        localStringBuilder.append(" 에 해당하는 택배는 존재하지 않습니다!");
        paramVoid.setMessage(localStringBuilder.toString()).setNegativeButton("확인", null).create().show();
        return;
      }
      fragmentinfo.this.getname.setText(fragmentinfo.this.vaules[7]);
      fragmentinfo.this.getgiver.setText(fragmentinfo.this.vaules[2]);
      fragmentinfo.this.getgetter.setText(fragmentinfo.this.vaules[3]);
      fragmentinfo.this.getendpoint.setText(fragmentinfo.this.vaules[4]);
      fragmentinfo.this.getdelivername.setText(fragmentinfo.this.vaules[5]);
      fragmentinfo.this.getsendtime.setText(fragmentinfo.this.vaules[8]);
      if (fragmentinfo.this.vaules[9].equals("NULL"))
      {
        fragmentinfo.this.getendtime.setText("배송중");
        return;
      }
      paramVoid = fragmentinfo.this.getendtime;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(fragmentinfo.this.vaules[9]);
      localStringBuilder.append(" 에 배송 완료");
      paramVoid.setText(localStringBuilder.toString());
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\fragmentinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */