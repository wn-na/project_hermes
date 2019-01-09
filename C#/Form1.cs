using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
using System.IO;
using System.Threading;

namespace arduino
{
    public partial class Form1 : Form
    {
        SerialPort port;
        public Form1()
        {
            InitializeComponent();
            this.FormClosed += new FormClosedEventHandler(Form1_FormClosed);

        }

        String USERIDCODE;

        void readOpenUSER()
        {
            while (true)
            {
                if (STATE == 0 || STATE == 1)
                {
                    WEBSETTING SETTING = new WEBSETTING(Config.CHECK_BOX_HOMEUSER, new CHECKBOX());
                    string str = SETTING.GetFirstValue();
                    if (USERID != str)
                    {
                        STATE = 0;
                        if (str != "0")
                        {
                            STATE = 1;
                            WEBSETTING NAME = new WEBSETTING(Config.GET_USER_NAME, "usercode=" + str);
                            USERNAME = NAME.GetResult();
                            USERIDCODE = str;
                        }
                        USERID = str;
                        port.Write("h");
                    }

                }
            }
        }
        void readOpenDRIVER()
        {
            while (true)
            {
                if (STATE == 0 || STATE == 2)
                {
                    WEBSETTING SETTING = new WEBSETTING(Config.CHECK_BOX_DRIVER, new CHECKBOX());
                    string str = SETTING.GetFirstValue();
                    if (USERID != str)
                    {
                        STATE = 0;
                        if (str != "0")
                        {
                            STATE = 2;
                            WEBSETTING NAME = new WEBSETTING(Config.GET_USER_NAME, "usercode=" + str);
                            USERNAME = NAME.GetResult();
                            USERIDCODE = str;
                        }
                        USERID = str;
                        pushPost();
                    }

                }
            }

        }

        Thread checkuser;
        Thread checkdriver;

        private bool CheckSerialPorts()
        {
            var names = SerialPort.GetPortNames();
            if (names.Length > 0)
            {
                comboBox1.Items.Clear();
                foreach (var name in names)
                {
                    comboBox1.Items.Add(name);
                }
                comboBox1.SelectedItem = names[0];
                return true;
            }

            return false;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("HOME");
            listBox1.Items.Add("HOMEUSER");
            listBox1.Items.Add("ADMIN");


            listBox2.Items.Add("POST");
            listBox2.Items.Add("POSTUSER");
            CheckSerialPorts();
        }

        void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            if (port != null && port.IsOpen)
            {
                port.Close();
            }

            checkuser.Abort();
            checkdriver.Abort();
        }
        List<string[]> postdata = new List<string[]>();
        //  List<string[]> postindex = new List<string[]>();
        int Count = 0;

        private bool SendLog(String user, String code)
        {
            CODEDATA finder = new CODEDATA();
            if (finder.findCode(code) == true)
            {
                WEBSETTING SETTING = new WEBSETTING(Config.SEND_LOG_PAGE, new LOG(user, code));
                return SETTING.CheckValue();
            }
            else
            {
                return true;
            }
        }


        DateTime dcode;
        private void CheckMessage(String text)
        {

            /*
            $ CHECK HOMEUSER");	CHK00
            $ CHECK POSTUSER");	CHK01
            & CLEAR");	CLE00
            & GET BOX");	CLE01
            & GET BOX CLEARLY");	CLE02
            ERROR");	ERR000
            & SOMETHING IS LEFT");	ERR001
            & BOX WAS DISAPPEAR");	ERR002
            * ERROR SOUND");	ERR005
            [NFCERROR] ERROR");	ERR009
            [HOMEUSER] DOOROPEN");	HOM00
            [HOMEUSER] DOORCLOSE");	HOM01
            [HOMEUSER] CLOSE 3MIN");	HOM03
            & LED OFF");	LED00
            & LED ON");	LED01
            [POSTUSER] DOOROPEN");	POS00
            [POSTUSER] DOORCLOSE");	POS01
            [POSTUSER] CLOSE 3MIN");	POS03
            */


            CODEDATA code = new CODEDATA();
            if (code.findCode(text) == true)
            {
                string txt = "";

                txt = DateTime.Now.ToString("HH:mm:ss");
                txt += "|";
                if (text == "HOM01" || text == "POS01")
                {
                    TimeSpan no = DateTime.Now - dcode;
                    if (no.TotalSeconds < 28.0)
                    {
                        txt += code.findLog(text, USERIDCODE);
                        while (SendLog(USERIDCODE, text) != true) ;
                    }

                    else
                    {
                        txt += code.findLog(text == "HOM01" ? "HOM03" : "POS03", USERIDCODE);
                        while (SendLog(USERIDCODE, text == "HOM01" ? "HOM03" : "POS03") != true) ;
                    }
                }
                else
                {

                    dcode = DateTime.Now;
                    txt += code.findLog(text, USERIDCODE);
                    while (SendLog(USERIDCODE, text) != true) ;
                }
                listBox3.Items.Add(txt);
                // dataGridView1.Rows.Add(txt);
                Count++;
                listBox3.SelectedIndex = listBox3.Items.Count - 1;
            }
            /*
            if (text == "CLE00")
                listBox5.Items.Clear();
            else if (text == "CLE01")
            {
                string post1 = textBox1.Text;
                string post2 = postlabel.ToString();
                string post3 = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");

                listBox4.Items.Add(postlabel.ToString());
                listBox5.Items.Add(postlabel.ToString());
                textBox2.Text = "배달원 : " + post1 + Environment.NewLine
                    + "운송장 번호 : " + post2 + Environment.NewLine
                    + "배달날짜 : " + post3;
                postdata.Add(new string[] { post1, post2, post3 });
                postlabel++;

            }
            else if (text == "CLE02")
            {
                string post1 = textBox1.Text;
                string post2 = postlabel.ToString();
                string post3 = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");

                listBox4.Items.Add(postlabel.ToString());
                listBox5.Items.Add(postlabel.ToString());
                textBox2.Text = "배달원 : " + post1 + Environment.NewLine
                    + "운송장 번호 : " + post2 + Environment.NewLine
                    + "배달날짜 : " + post3;
                postdata.Add(new string[] { post1, post2, post3 });
                postlabel++;
            }
            else if (text == "ERR002")
            {
                string[] tmp = new string[3];
                string datae = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");
                tmp = postdata[postdata.Count];
                textBox2.Text = "배달원 : " + tmp[0] + Environment.NewLine +
                    "운송장 번호 : " + tmp[1] + Environment.NewLine +
                    "배달날짜 : " + tmp[2] + Environment.NewLine +
                    "경고날짜 : " + datae;
                //  postindex.Add(new string[] { tmp[1], "delete", datae });

            }
        }
        /*
        if (text.CompareTo("CHK00") == 0)
        {
            txt += " 확  인 |물건 수령여부를 확인하고 있습니다.";
        }
        else if (text == "CHK01")
        {
            txt += "배송확인|배송 확인 여부를 확인하고 있습니다.";
        }
        else if (text == "CLE00")
        {
            txt += "확인완료|택배를 정상적으로 수령했습니다.";
            listBox5.Items.Clear();
        }
        else if (text == "CLE01")
        {
            txt += "배송완료|새로운 택배가 정상적으로 도착햇습니다.";
            string post1 = textBox1.Text;
            string post2 = postlabel.ToString();
            string post3 = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");

            listBox4.Items.Add(postlabel.ToString());
            listBox5.Items.Add(postlabel.ToString());
            textBox2.Text = "배달원 : " + post1 + Environment.NewLine
                + "운송장 번호 : " + post2 + Environment.NewLine
                + "배달날짜 : " + post3;
            postdata.Add(new string[] { post1, post2, post3 });
            postlabel++;

        }
        else if (text == "CLE02")
        {
            txt += "배송완료|또다른 택배가 정상적으로 도착햇습니다.";
            string post1 = textBox1.Text;
            string post2 = postlabel.ToString();
            string post3 = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");

            listBox4.Items.Add(postlabel.ToString());
            listBox5.Items.Add(postlabel.ToString());
            textBox2.Text = "배달원 : " + post1 + Environment.NewLine
                + "운송장 번호 : " + post2 + Environment.NewLine
                + "배달날짜 : " + post3;
            postdata.Add(new string[] { post1, post2, post3 });
            postlabel++;
        }
        else if (text == "ERR000")
        {
            txt += " 에  러 |알수없는 에러";
        }
        else if (text == "ERR001")
        {
            txt += " 경  고 |택배가 남아있습니다.";

        }
        else if (text == "ERR002")
        {
            txt += " 위  험 |택배가 사라졌습니다.";
            string[] tmp = new string[3];
            string datae = DateTime.Now.ToString("yy-MM-dd HH:mm:ss");
            tmp = postdata[postdata.Count];
            textBox2.Text = "배달원 : " + tmp[0] + Environment.NewLine +
                "운송장 번호 : " + tmp[1] + Environment.NewLine +
                "배달날짜 : " + tmp[2] + Environment.NewLine +
                "경고날짜 : " + datae;
            //  postindex.Add(new string[] { tmp[1], "delete", datae });

        }
        else if (text == "ERR005")
        {
            txt += "경 고 음";
        }
        else if (text == "ERR009")
        {
            txt += " 에  러 | 사용자 [" + textBox1.Text + "] 를 알 수 없습니다.";

        }
        else if (text == "HOM00")
        {
            txt += "고 객 님|택배보관함이 열렸습니다.";
        }
        else if (text == "HOM01")
        {
            txt += "고 객 님|택배보관함이 닫혔습니다.";
        }
        else if (text == "HOM03")
        {
            txt += "고 객 님|3분이 지나 자동으로 닫힙니다.";
        }
        else if (text == "LED00")
        {
            txt += " 점  등 |꺼졌습니다.";
        }
        else if (text == "LED01")
        {
            txt += " 점  등 |켜졌습니다.";

        }
        else if (text == "POS00")
        {
            txt += "택배기사|택배보관함이 열렸습니다.";
        }
        else if (text == "POS01")
        {
            txt += "택배기사|택배보관함이 닫혔습니다.";
        }
        else if (text == "POS03")
        {
            txt += "택배기사|3분이 지나 자동으로 닫힙니다.";

        }
        else
        {
            txt += "Error|Undefined Command";

        }
        */
        }

        private void Read(object sender, SerialDataReceivedEventArgs e)
        {
            try
            {
                string message = port.ReadLine();
                CheckMessage(message.Replace("\r", string.Empty));
            }
            catch (TimeoutException) { }
        }


        int postlabel = 1800000;
        private void pushPost()
        {
            port.Write("p");


        }

        String USERNAME = "";
        String USERID = "0";
        int USERTYPE = 0;
        int STATE = 0;



        private void button1_Click(object sender, EventArgs e)
        {
            if (listBox1.FindString(textBox1.Text) == -1)
            {

                if (listBox2.FindString(textBox1.Text) == -1)
                {
                    port.Write("e");

                }
                else
                {
                    pushPost();
                }
            }
            else
            {

                port.Write("h");

            }


        }

        private void button2_Click(object sender, EventArgs e)
        {
            port.Write("h");
            USERNAME = textBox1.Text;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "")
                pushPost();
            else textBox1.Focus();
            USERNAME = textBox1.Text;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            SaveFileDialog save = new SaveFileDialog();
            String sPath = "";
            save.InitialDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            save.Title = "로그 저장위치 지정";
            save.FileName = "logdata_" + DateTime.Now.ToString("yy_MM_dd_HH_mm_ss") + ".log";
            save.Filter = "Log File (*.log)|*.log|Text File (*.txt)|*.txt|All Files (*.*)|*.*";
            save.DefaultExt = "log";
            if (save.ShowDialog() == DialogResult.OK)
            {
                sPath = save.FileName.ToString();



                using (TextWriter tWriter = new StreamWriter(sPath))
                {
                    foreach (var name in listBox3.Items)
                    {
                        tWriter.WriteLine(name);
                    }
                    //for(i = 0; i < dataGridView1.Rows.Count; i++)
                    //{
                    //    tWriter.WriteLine(String.Format("{0}|{1}|{2}",
                    //        dataGridView1.Rows[i].Cells[0].Value.ToString(),
                    //        dataGridView1.Rows[i].Cells[1].Value.ToString(),
                    //        dataGridView1.Rows[i].Cells[2].Value.ToString()));
                    //}
                }
            }
        }

        private void listBox3_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (port == null)
            {
                checkuser = new Thread(new ThreadStart(readOpenUSER));
                checkdriver = new Thread(new ThreadStart(readOpenDRIVER));
                port = new SerialPort(comboBox1.SelectedItem.ToString(), 9600);//Set your board COM
                port.DataReceived += Read;
                port.Open();
                button1.Enabled = true;
                button2.Enabled = true;
                button3.Enabled = true;
                checkuser.Start();
                checkdriver.Start();
            }
            button5.Enabled = false;
        }

        private void listBox3_SelectedIndexChanged_1(object sender, EventArgs e)
        {

        }

        private void groupBox5_Enter(object sender, EventArgs e)
        {

        }

        private void listBox4_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void listBox4_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            int selectedIndex = -1; // 마우스 포인터의 위치 
            Point point = e.Location; // 리스트 박스의 IndexFromPoint 메서드 호출 
            selectedIndex = listBox4.IndexFromPoint(point);
            if (selectedIndex != -1) // 빈 공간이 아닌 곳을 더블클릭 했을 때. 
            {
                // 선택된 항목 저장 
                string selectedItem = listBox4.Items[selectedIndex] as string; // 선택한 항목으로 텍스트 대입 

                foreach (var data in postdata)
                {
                    if (selectedItem == data[1])
                    {
                        textBox3.Text = "배달원 : " + data[0] + Environment.NewLine
                            + "운송장 번호 : " + data[1] + Environment.NewLine
                            + "배달날짜 : " + data[2];
                        break;
                    }
                }

            }
        }

        private void listBox2_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            int selectedIndex = -1; // 마우스 포인터의 위치 
            Point point = e.Location; // 리스트 박스의 IndexFromPoint 메서드 호출 
            selectedIndex = listBox2.IndexFromPoint(point);
            if (selectedIndex != -1) // 빈 공간이 아닌 곳을 더블클릭 했을 때. 
            {
                // 선택된 항목 저장 
                string selectedItem = listBox2.Items[selectedIndex] as string; // 선택한 항목으로 텍스트 대입 
                textBox1.Text = selectedItem;
            }

        }

        private void listBox1_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            int selectedIndex = -1; // 마우스 포인터의 위치 
            Point point = e.Location; // 리스트 박스의 IndexFromPoint 메서드 호출 
            selectedIndex = listBox1.IndexFromPoint(point);
            if (selectedIndex != -1) // 빈 공간이 아닌 곳을 더블클릭 했을 때. 
            {
                // 선택된 항목 저장 
                string selectedItem = listBox1.Items[selectedIndex] as string; // 선택한 항목으로 텍스트 대입 
                textBox1.Text = selectedItem;
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            SaveFileDialog save = new SaveFileDialog();
            String sPath = "";
            save.InitialDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);
            save.Title = "로그 저장위치 지정";
            save.FileName = "postdata_" + DateTime.Now.ToString("yy_MM_dd_HH_mm_ss") + ".log";
            save.Filter = "Log File (*.log)|*.log|Text File (*.txt)|*.txt|All Files (*.*)|*.*";
            save.DefaultExt = "log";
            if (save.ShowDialog() == DialogResult.OK)
            {
                sPath = save.FileName.ToString();



                using (TextWriter tWriter = new StreamWriter(sPath))
                {
                    foreach (var data in postdata)
                    {
                        tWriter.WriteLine("배달원 : " + data[0]
                            + " | 운송장 번호 : " + data[1]
                            + " | 배달날짜 : " + data[2]);
                    }
                }
            }
        }


        private void listBox5_MouseDoubleClick_1(object sender, MouseEventArgs e)
        {
            int selectedIndex = -1; // 마우스 포인터의 위치 
            Point point = e.Location; // 리스트 박스의 IndexFromPoint 메서드 호출 
            selectedIndex = listBox5.IndexFromPoint(point);
            if (selectedIndex != -1) // 빈 공간이 아닌 곳을 더블클릭 했을 때. 
            {
                // 선택된 항목 저장 
                string selectedItem = listBox5.Items[selectedIndex] as string; // 선택한 항목으로 텍스트 대입 

                foreach (var data in postdata)
                {
                    if (selectedItem == data[1])
                    {
                        textBox3.Text = "배달원 : " + data[0] + Environment.NewLine
                            + "운송장 번호 : " + data[1] + Environment.NewLine
                            + "배달날짜 : " + data[2];
                        break;
                    }
                }

            }

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button9_Click(object sender, EventArgs e)
        {
            port.Write("e");
        }

        private void button8_Click(object sender, EventArgs e)
        {

            port.Write("d");
        }

        private void button7_Click(object sender, EventArgs e)
        {

            port.Write("w");
        }
    }
}
