package com.dsml.monjava.deliverycheck;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class registerActivity
  extends AppCompatActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private EditText Callnumber;
  private EditText Email;
  private EditText ID;
  private EditText Name;
  private EditText Password;
  private EditText Passwordcheck;
  int boxidcount = 0;
  private Button boxidentitycheck;
  int boxidentityn = 0;
  private EditText boxidentitynumber;
  private EditText boxidentitypassword;
  int boxipwtrue;
  int boxitrue;
  private Spinner call;
  int calltrue;
  private Spinner company;
  int emailtrue;
  private Button idcheck;
  int idchecked = 0;
  private CheckBox identity;
  private Button identitycheck;
  int identityn = 0;
  private EditText identitynumber;
  int idtrue;
  int itrue = 0;
  private String jsoupboxidentity;
  private String jsoupboxpassword;
  private String jsoupecal;
  private String jsoupemail;
  private String jsoupid;
  private String jsoupidentity;
  private String jsoupname;
  private String jsouppassword;
  private String jsouptype;
  long m_exitPressedTime;
  int nametrue;
  int pwctrue;
  int pwtrue;
  private Button registerbutton;
  int usercheck = 0;
  private String vaulebox;
  private String vauledeliver;
  private String vauleid;
  private String vauleregister;
  
  private boolean checkFill()
  {
    return (this.nametrue == 1) && (this.idtrue == 1) && (this.pwtrue == 1) && (this.pwctrue == 1) && (this.emailtrue == 1) && (this.calltrue == 1) && (this.boxitrue == 1) && (this.boxipwtrue == 1) && ((this.usercheck == 0) || ((this.usercheck == 1) && (this.itrue == 1)));
  }
  
  public void onBackPressed()
  {
    Toast.makeText(this, "뒤로 가기 키를 한번 더 누르시면 로그인 창으로 다시 돌아갑니다.", 0).show();
    long l = System.currentTimeMillis();
    if (l - this.m_exitPressedTime <= 1500L)
    {
      finish();
      return;
    }
    this.m_exitPressedTime = l;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.identity.isChecked())
    {
      this.identitynumber.setEnabled(true);
      this.identitynumber.setText("");
      this.identitynumber.setVisibility(0);
      this.identitycheck.setVisibility(0);
      this.company.setVisibility(0);
      this.registerbutton.setEnabled(false);
      this.itrue = 0;
      this.usercheck = 1;
      return;
    }
    this.identitynumber.setVisibility(8);
    this.identitycheck.setVisibility(8);
    this.company.setVisibility(8);
    this.usercheck = 0;
    if (checkFill())
    {
      this.registerbutton.setEnabled(true);
      return;
    }
    this.registerbutton.setEnabled(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131427359);
    this.ID = ((EditText)findViewById(2131296420));
    this.identity = ((CheckBox)findViewById(2131296421));
    this.identitynumber = ((EditText)findViewById(2131296422));
    this.boxidentitynumber = ((EditText)findViewById(2131296416));
    this.boxidentitypassword = ((EditText)findViewById(2131296417));
    this.identitycheck = ((Button)findViewById(2131296364));
    this.boxidentitycheck = ((Button)findViewById(2131296302));
    this.idcheck = ((Button)findViewById(2131296261));
    this.Name = ((EditText)findViewById(2131296423));
    this.Password = ((EditText)findViewById(2131296424));
    this.Passwordcheck = ((EditText)findViewById(2131296425));
    this.Email = ((EditText)findViewById(2131296419));
    this.Callnumber = ((EditText)findViewById(2131296418));
    this.call = ((Spinner)findViewById(2131296469));
    this.company = ((Spinner)findViewById(2131296470));
    this.registerbutton = ((Button)findViewById(2131296426));
    this.registerbutton.setEnabled(false);
    this.Name.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (registerActivity.this.Name.getText().toString().equals(""))
        {
          registerActivity.this.Name.setError("입력한 값이 없습니다.");
          registerActivity.this.nametrue = 0;
        }
        else
        {
          registerActivity.this.nametrue = 1;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ID.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = registerActivity.this.ID.getText().length();
        if ((!registerActivity.this.ID.getText().toString().equals("")) && (i >= 6))
        {
          registerActivity.this.idtrue = 1;
        }
        else
        {
          registerActivity.this.ID.setError("입력한 값이 없거나 짧습니다.");
          registerActivity.this.idtrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (registerActivity.this.idchecked == 1)
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("입력 변경시 다시 중복 확인을 해야합니다.").setNegativeButton("확인", null).create().show();
          registerActivity.this.idchecked = 0;
        }
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Password.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = registerActivity.this.Password.getText().length();
        if (registerActivity.this.pwtrue > 0) {
          registerActivity.this.Passwordcheck.setText("");
        }
        if ((!registerActivity.this.Password.getText().toString().equals("")) && (i >= 8))
        {
          registerActivity.this.pwtrue = 1;
        }
        else
        {
          registerActivity.this.Password.setError("입력한 값이 없거나 짧습니다");
          registerActivity.this.pwtrue = 2;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Passwordcheck.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = registerActivity.this.Passwordcheck.getText().length();
        if ((!registerActivity.this.Passwordcheck.getText().toString().equals("")) && (i >= 8) && (registerActivity.this.Password.getText().toString().equals(registerActivity.this.Passwordcheck.getText().toString())))
        {
          registerActivity.this.pwctrue = 1;
        }
        else
        {
          registerActivity.this.Passwordcheck.setError("입력한 값이 없거나 비밀번호가 틀립니다.");
          registerActivity.this.pwctrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Email.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((registerActivity.this.Email.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) && (paramAnonymousEditable.length() > 0))
        {
          registerActivity.this.emailtrue = 1;
        }
        else
        {
          registerActivity.this.Email.setError("입력한 값이 없거나 잘못되었습니다.");
          registerActivity.this.emailtrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Callnumber.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        String str = registerActivity.this.Callnumber.getText().toString().trim();
        StringBuilder localStringBuilder;
        if ((paramAnonymousEditable.length() > registerActivity.this.boxidcount) && (paramAnonymousEditable.length() == 4))
        {
          paramAnonymousEditable = registerActivity.this.Callnumber;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(registerActivity.this.Callnumber.getText());
          localStringBuilder.append("-");
          paramAnonymousEditable.setText(localStringBuilder.toString());
          registerActivity.this.Callnumber.setSelection(registerActivity.this.Callnumber.length());
        }
        else if ((paramAnonymousEditable.length() <= registerActivity.this.boxidcount) && (paramAnonymousEditable.length() > 3) && (registerActivity.this.Callnumber.getText().toString().substring(registerActivity.this.Callnumber.length() - 1, registerActivity.this.Callnumber.length()).equals("-")))
        {
          registerActivity.this.Callnumber.setText(registerActivity.this.Callnumber.getText().toString().substring(0, registerActivity.this.Callnumber.length() - 1));
          registerActivity.this.Callnumber.setSelection(registerActivity.this.Callnumber.length());
        }
        else if ((paramAnonymousEditable.length() == 5) && (!registerActivity.this.Callnumber.getText().toString().substring(registerActivity.this.Callnumber.length() - 1, registerActivity.this.Callnumber.length()).equals("-")))
        {
          paramAnonymousEditable = registerActivity.this.Callnumber;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(registerActivity.this.Callnumber.getText().toString().substring(0, registerActivity.this.Callnumber.length() - 1));
          localStringBuilder.append("-");
          localStringBuilder.append(registerActivity.this.Callnumber.getText().toString().substring(registerActivity.this.Callnumber.length() - 1, registerActivity.this.Callnumber.length()));
          paramAnonymousEditable.setText(localStringBuilder.toString());
          registerActivity.this.Callnumber.setSelection(registerActivity.this.Callnumber.length());
        }
        if ((!registerActivity.this.Callnumber.getText().toString().equals("")) && (str.matches("([0-9]{4}|[0-9]{3})+\\-+[0-9]{4}+")))
        {
          registerActivity.this.calltrue = 1;
        }
        else
        {
          registerActivity.this.Callnumber.setError("입력한 값이 없거나 숫자 형식이 아닙니다");
          registerActivity.this.calltrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.identitynumber.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable = registerActivity.this.identitynumber.getText().toString().trim();
        if ((!registerActivity.this.identitynumber.getText().toString().equals("")) && (!paramAnonymousEditable.matches("[0-9]{12}+")))
        {
          registerActivity.this.itrue = 1;
        }
        else
        {
          registerActivity.this.identitynumber.setError("입력한 값이 없습니다.");
          registerActivity.this.itrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.boxidentitynumber.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        String str = registerActivity.this.boxidentitynumber.getText().toString().trim();
        EditText localEditText;
        StringBuilder localStringBuilder;
        if ((paramAnonymousEditable.length() > registerActivity.this.boxidcount) && ((paramAnonymousEditable.length() == 4) || (paramAnonymousEditable.length() == 9) || (paramAnonymousEditable.length() == 14)))
        {
          localEditText = registerActivity.this.boxidentitynumber;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(registerActivity.this.boxidentitynumber.getText());
          localStringBuilder.append("-");
          localEditText.setText(localStringBuilder.toString());
          registerActivity.this.boxidentitynumber.setSelection(registerActivity.this.boxidentitynumber.length());
        }
        else if ((paramAnonymousEditable.length() <= registerActivity.this.boxidcount) && (paramAnonymousEditable.length() > 3) && (registerActivity.this.boxidentitynumber.getText().toString().substring(registerActivity.this.boxidentitynumber.length() - 1, registerActivity.this.boxidentitynumber.length()).equals("-")))
        {
          registerActivity.this.boxidentitynumber.setText(registerActivity.this.boxidentitynumber.getText().toString().substring(0, registerActivity.this.boxidentitynumber.length() - 1));
          registerActivity.this.boxidentitynumber.setSelection(registerActivity.this.boxidentitynumber.length());
        }
        else if (((paramAnonymousEditable.length() == 5) && (!registerActivity.this.boxidentitynumber.getText().toString().substring(registerActivity.this.boxidentitynumber.length() - 1, registerActivity.this.boxidentitynumber.length()).equals("-"))) || ((paramAnonymousEditable.length() == 10) && (!registerActivity.this.boxidentitynumber.getText().toString().substring(registerActivity.this.boxidentitynumber.length() - 1, registerActivity.this.boxidentitynumber.length()).equals("-"))) || ((paramAnonymousEditable.length() == 15) && (!registerActivity.this.boxidentitynumber.getText().toString().substring(registerActivity.this.boxidentitynumber.length() - 1, registerActivity.this.boxidentitynumber.length()).equals("-"))))
        {
          localEditText = registerActivity.this.boxidentitynumber;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(registerActivity.this.boxidentitynumber.getText().toString().substring(0, registerActivity.this.boxidentitynumber.length() - 1));
          localStringBuilder.append("-");
          localStringBuilder.append(registerActivity.this.boxidentitynumber.getText().toString().substring(registerActivity.this.boxidentitynumber.length() - 1, registerActivity.this.boxidentitynumber.length()));
          localEditText.setText(localStringBuilder.toString());
          registerActivity.this.boxidentitynumber.setSelection(registerActivity.this.boxidentitynumber.length());
        }
        if ((!registerActivity.this.boxidentitynumber.getText().toString().equals("")) && (str.matches("[0-9]{4}+\\-+[0-9]{4}+\\-+[0-9]{4}+\\-+[0-9]{4}+")))
        {
          registerActivity.this.boxitrue = 1;
        }
        else
        {
          registerActivity.this.boxidentitynumber.setError("입력된 값이 없습니다.");
          registerActivity.this.boxitrue = 0;
        }
        registerActivity.this.boxidcount = paramAnonymousEditable.length();
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.boxidentitypassword.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable = registerActivity.this.boxidentitypassword.getText().toString().trim();
        if ((!registerActivity.this.boxidentitypassword.getText().toString().equals("")) && (paramAnonymousEditable.matches("[0-9]+")))
        {
          registerActivity.this.boxipwtrue = 1;
        }
        else
        {
          registerActivity.this.boxidentitypassword.setError("입력한 값이 없습니다.");
          registerActivity.this.boxipwtrue = 0;
        }
        if (registerActivity.this.checkFill())
        {
          registerActivity.this.registerbutton.setEnabled(true);
          return;
        }
        registerActivity.this.registerbutton.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.registerbutton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((registerActivity.this.idchecked == 1) && ((registerActivity.this.identityn == 1) || (registerActivity.this.boxidentityn == 1)))
        {
          registerActivity.access$1102(registerActivity.this, registerActivity.this.boxidentitynumber.getText().toString());
          registerActivity.access$1202(registerActivity.this, registerActivity.this.boxidentitypassword.getText().toString());
          registerActivity.access$1302(registerActivity.this, registerActivity.this.Name.getText().toString());
          registerActivity.access$1402(registerActivity.this, registerActivity.this.ID.getText().toString());
          registerActivity.access$1502(registerActivity.this, registerActivity.this.Password.getText().toString());
          registerActivity.access$1602(registerActivity.this, registerActivity.this.Email.getText().toString());
          registerActivity.access$1702(registerActivity.this, registerActivity.this.identitynumber.getText().toString());
          registerActivity.access$1802(registerActivity.this, registerActivity.this.Callnumber.getText().toString());
          registerActivity.access$1902(registerActivity.this, String.valueOf(registerActivity.this.usercheck));
          new registerActivity.JsoupAsyncTaskregister(registerActivity.this, null).execute(new Void[0]);
          return;
        }
        if ((registerActivity.this.idchecked == 0) && ((registerActivity.this.boxidentityn == 1) || (registerActivity.this.identityn == 1)))
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("ID 중복확인을 해주세요!").setNegativeButton("확인", null).create().show();
          return;
        }
        if ((registerActivity.this.boxidentityn == 0) && (registerActivity.this.usercheck == 0) && (registerActivity.this.idchecked == 1))
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("보관함 인증을 해주세요!").setNegativeButton("확인", null).create().show();
          return;
        }
        if ((registerActivity.this.identityn == 0) && (registerActivity.this.usercheck == 1) && (registerActivity.this.idchecked == 1))
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("택배기사 인증을 해주세요!").setNegativeButton("확인", null).create().show();
          return;
        }
        new AlertDialog.Builder(registerActivity.this).setMessage("인증 버튼을 전부 확인해 주세요!").setNegativeButton("확인", null).create().show();
      }
    });
    this.idcheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (registerActivity.this.ID.getText().length() < 6)
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("ID는 6자부터 12자까지 가능합니다!").setNegativeButton("확인", null).create().show();
          return;
        }
        registerActivity.access$1402(registerActivity.this, registerActivity.this.ID.getText().toString());
        new registerActivity.JsoupAsyncTaskidcheck(registerActivity.this, null).execute(new Void[0]);
      }
    });
    this.identity.setOnCheckedChangeListener(this);
    this.boxidentitycheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((!registerActivity.this.boxidentitynumber.getText().toString().equals("")) && (!registerActivity.this.boxidentitypassword.getText().toString().equals("")))
        {
          registerActivity.access$1102(registerActivity.this, registerActivity.this.boxidentitynumber.getText().toString());
          registerActivity.access$1202(registerActivity.this, registerActivity.this.boxidentitypassword.getText().toString());
          new registerActivity.JsoupAsyncTaskboxcheck(registerActivity.this, null).execute(new Void[0]);
          return;
        }
        new AlertDialog.Builder(registerActivity.this).setMessage("빈칸을 확인해 주세요!").setNegativeButton("확인", null).create().show();
      }
    });
    this.identitycheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (registerActivity.this.identitynumber.getText().toString().equals(""))
        {
          new AlertDialog.Builder(registerActivity.this).setMessage("빈칸을 확인해 주세요!").setNegativeButton("확인", null).create().show();
          return;
        }
        registerActivity.access$1302(registerActivity.this, registerActivity.this.Name.getText().toString());
        registerActivity.access$1702(registerActivity.this, registerActivity.this.identitynumber.getText().toString());
        new registerActivity.JsoupAsyncTaskdelivercheck(registerActivity.this, null).execute(new Void[0]);
      }
    });
    this.company.setVisibility(8);
    this.identitynumber.setVisibility(8);
    this.identitycheck.setVisibility(8);
  }
  
  private class JsoupAsyncTaskboxcheck
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskboxcheck() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/checkboxidentity.php?boxidentity=");
        paramVarArgs.append(registerActivity.this.jsoupboxidentity);
        paramVarArgs.append("&cvc=");
        paramVarArgs.append(registerActivity.this.jsoupboxpassword);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        registerActivity.access$2602(registerActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (registerActivity.this.vaulebox.equals("True/"))
      {
        new AlertDialog.Builder(registerActivity.this).setMessage("보관함이 인증되었습니다.").setNegativeButton("확인", null).create().show();
        registerActivity.this.boxidentitynumber.setEnabled(false);
        registerActivity.this.boxidentitypassword.setEnabled(false);
        registerActivity.this.boxidentityn = 1;
        return;
      }
      new AlertDialog.Builder(registerActivity.this).setMessage("보관함이 인증되지 않았습니다. 다시 확인해 주세요.").setNegativeButton("확인", null).create().show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskdelivercheck
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskdelivercheck() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/confirmprocess.php?Name=");
        paramVarArgs.append(registerActivity.this.jsoupname);
        paramVarArgs.append("&Didentity=");
        paramVarArgs.append(registerActivity.this.jsoupidentity);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        registerActivity.access$2702(registerActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (registerActivity.this.vauledeliver.equals("True/"))
      {
        new AlertDialog.Builder(registerActivity.this).setMessage("택배기사 식별이 확인되었습니다.").setNegativeButton("확인", null).create().show();
        registerActivity.this.identitynumber.setEnabled(false);
        registerActivity.this.identityn = 1;
        return;
      }
      new AlertDialog.Builder(registerActivity.this).setMessage("택배기사 식별이 확인되지 않았습니다. 다시 시도해 주세요.").setNegativeButton("확인", null).create().show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskidcheck
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskidcheck() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/checkid.php?id=");
        paramVarArgs.append(registerActivity.this.jsoupid);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        registerActivity.access$2502(registerActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (registerActivity.this.vauleid.equals("True/"))
      {
        new AlertDialog.Builder(registerActivity.this).setMessage("이 ID는 사용이 가능합니다.").setNegativeButton("확인", null).create().show();
        registerActivity.this.ID.setEnabled(false);
        registerActivity.this.idchecked = 1;
        return;
      }
      new AlertDialog.Builder(registerActivity.this).setMessage("이 ID는 이미 사용중 입니다! 다시 입력해 주세요.").setNegativeButton("확인", null).create().show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  private class JsoupAsyncTaskregister
    extends AsyncTask<Void, Void, Void>
  {
    private JsoupAsyncTaskregister() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("http://osias.asuscomm.com/~post/member_create.php?name=");
        paramVarArgs.append(registerActivity.this.jsoupname);
        paramVarArgs.append("&id=");
        paramVarArgs.append(registerActivity.this.jsoupid);
        paramVarArgs.append("&password=");
        paramVarArgs.append(registerActivity.this.jsouppassword);
        paramVarArgs.append("&email=");
        paramVarArgs.append(registerActivity.this.jsoupemail);
        paramVarArgs.append("&phone=010-");
        paramVarArgs.append(registerActivity.this.jsoupecal);
        paramVarArgs.append("&boxnumber=");
        paramVarArgs.append(registerActivity.this.jsoupboxidentity);
        paramVarArgs.append("&boxcvc=");
        paramVarArgs.append(registerActivity.this.jsoupboxpassword);
        paramVarArgs.append("&Type=");
        paramVarArgs.append(registerActivity.this.jsouptype);
        paramVarArgs.append("&PostCompany=CJ&PostIdentity=");
        paramVarArgs.append(registerActivity.this.jsoupidentity);
        paramVarArgs = Jsoup.connect(paramVarArgs.toString()).method(Connection.Method.GET).execute().parse();
        registerActivity.access$2402(registerActivity.this, paramVarArgs.text());
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (registerActivity.this.vauleregister.equals("True/"))
      {
        Toast.makeText(registerActivity.this.getApplicationContext(), "회원가입이 완료되었습니다! 로그인을 시도해 주세요.", 0).show();
        paramVoid = new Intent(registerActivity.this, LoginActivity.class);
        registerActivity.this.startActivity(paramVoid);
        registerActivity.this.finish();
        return;
      }
      new AlertDialog.Builder(registerActivity.this).setMessage("회원가입에 실패 하였습니다.").setNegativeButton("확인", null).create().show();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              C:\dex2jar-2.0\com.dsml.monjava.deliverycheck-dex2jar.jar!\com\dsml\monjava\deliverycheck\registerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */