using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.IO;

namespace arduino
{
    public enum CODETYPE { NORMAL,WARNING,ERROR};
    public class CODEDATA
    {
        private List<LOGDATA> DATA = new List<LOGDATA> {
            new LOGDATA("CLE00","user님이 택배를 정상적으로 수령하였습니다.", CODETYPE.NORMAL),
            new LOGDATA("CLE01", "택배기사 user님이 택배를 배달하였습니다", CODETYPE.NORMAL),
            new LOGDATA("CLE02", "택배기사 user님이 또다른 택배를 배달하였습니다", CODETYPE.NORMAL),
            new LOGDATA("ERR001", "택배가 남아있습니다. 최근 이용자 : user",CODETYPE.WARNING),
            new LOGDATA("ERR002", "택배가 사라졌습니다. 최근 이용자 : user",CODETYPE.ERROR),
            new LOGDATA("ERR009", "user를 식별 할 수 없습니다.",CODETYPE.ERROR),
            new LOGDATA("HOM00", "사용자 user가 문을 열었습니다.", CODETYPE.NORMAL),
            new LOGDATA("HOM01", "사용자 user가 문을 닫았습니다.", CODETYPE.NORMAL),
            new LOGDATA("HOM03", "사용자 user가 문을 연지 3분이 지나 자동으로 닫힙니다.",CODETYPE.WARNING),
            new LOGDATA("POS00", "택배기사 user가 문을 열었습니다.", CODETYPE.NORMAL),
            new LOGDATA("POS01", "택배기사 user가 문을 닫았습니다.", CODETYPE.NORMAL),
            new LOGDATA("POS03", "택배기사 user가 문을 연지 3분이 지나 자동으로 닫힙니다.",CODETYPE.WARNING) };

        public String findLog(String code, String name)
        {
             WEBSETTING NAME = new WEBSETTING(Config.GET_USER_NAME, "usercode=" + name);
              String USERNAME = NAME.GetResult();
                foreach (LOGDATA log in DATA)
            {
                if (log.getCode() == code)
                    return log.getExplanation(USERNAME+"(ID : " + name + ")");
            }
            return USERNAME + "가 알 수 없는 에러를 실행하였습니다.";
        }

        public bool findCode(String code)
        {
            foreach (LOGDATA log in DATA)
            {
                if (log.getCode() == code)
                    return true;
            }
            return false;
        }

        public string getType(String code)
        {
            foreach(LOGDATA log in DATA)
            {
                if(log.getCode() == code)
                    return log.getType().ToString();
            }
            return "NULL";
        }
    }

    public class LOG
    {
        private String boxnumber;
        private String UserID;
        private String Code;
        private String Time;
        private String Log;

        public LOG(String UserID, String Code)
        {
            this.boxnumber = Config.BOXIDENETIY;
            this.UserID = UserID;
            this.Code = Code;
            this.Time = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");
            this.Log = GetLog();
        }

        public override string ToString() {
            return "boxnumber=" + this.boxnumber 
                + "&UserID=" + this.UserID 
                + "&Code=" + this.Code
                + "&Time=" + this.Time 
                + "&Log=" + this.Log;
        }
        
        // 로그를 반환
        public String GetLog()
        {
            CODEDATA code = new CODEDATA();
            return code.findLog(Code, UserID);
        }

    }

    public class LOGDATA
    {
        private string Code;
        private string Explanation;
        private CODETYPE type;
        public LOGDATA(string Code, string Explanation, CODETYPE type)
        {
            this.Code = Code;
            this.Explanation = Explanation;
            this.type = type;
        }

        public string getExplanation(string name)
        {
            return Explanation.Replace("user", name);
        }
        public string getCode()
        {
            return Code;
        }
        public CODETYPE getType()
        {
            return type;
        }
    }

    public class WEBSETTING
    {
        // 주소 설정
        private const string URL = "http://osias.asuscomm.com/~post/";

        private String Page;
        private object Type;
        private String Result;

        public WEBSETTING(String page, object type)
        {
            this.Type = type;
            this.Page = URL + page + ".php?" + Type.ToString();
            this.Result = GetResult();
        }

        public String GetURL()
        {
            return Page;
        }

        // 페이지 결과를 리턴
        public String GetResult()
        {
            WebRequest wrGETURL;
            wrGETURL = WebRequest.Create(Page);

            Stream objStream;
            objStream = wrGETURL.GetResponse().GetResponseStream();

            StreamReader objReader = new StreamReader(objStream);

            return objReader.ReadLine();
        }

        public String GetFirstValue()
        {
            var parts = Result.Split('/');
            return Convert.ToString(parts[0]);
        }
        // 첫번째 값이 참인지 거짓인지 반환
        public bool CheckValue()
        {
            var parts = Result.Split('/');
            string a = Convert.ToString(parts[0]);

            if (a == "True") return true;
            else return false;
        }
    }


    public class CHECKBOX
    {
        private String boxnumber;

        public CHECKBOX()
        {
            this.boxnumber = Config.BOXIDENETIY;
        }

        public override string ToString()
        {
            return "boxID=" + this.boxnumber;
        }
    }


    public class Config
    {
        // 페이지 설정
        public const String SEND_LOG_PAGE = "sendlog";
        public const String CHECK_BOX_HOMEUSER = "checkBoxHomeUser";
        public const String CHECK_BOX_DRIVER = "checkBoxDriver";
        public const String GET_USER_NAME = "getusername";

        // 박스 고유 주소
        public const String BOXIDENETIY = "2018-0611-1030-1230";
        public const String BOXPASSWORD = "17019";
    }

}
