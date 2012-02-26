package content.ustc.cn;
import java.util.List;
import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.app.Activity;
public class NewsContentActivity extends Activity {
	/** Called when the activity is first created. */
	private static final String serviceNameSpace = "http://ustcNews";//���������ռ�
	private static final String GetNewsTitleList = "GetNewsContList";//����Զ�̷���
	private static final String serviceURL = "http://192.168.1.89:8080/axis2/services/NewsContent_ustc";//���÷���ĵ�ַ
	public static List<String> GetNewsConList(int titleId) {
		Vector<String> result = null;//�������صĽ��
		SoapObject request = new SoapObject(serviceNameSpace, GetNewsTitleList);//�½�request
	    request.addProperty("titleId", titleId);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(//����soap�ŷ�İ汾
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.bodyOut = request;
		envelope.setOutputSoapObject(request);
		HttpTransportSE ht = new HttpTransportSE(serviceURL);//�󶨷����ַ
		ht.debug = true;
	try{
			ht.call(serviceNameSpace  +"/"+ GetNewsTitleList, envelope);
			 result = (Vector<String>) envelope.getResponse();//�ѷ��صĽ����ֵ��result
	} catch (Exception e) {
		System.out.println(("��webservice��ȡ��Ϣ����"));//��׽�쳣
	}
		return  result;
	}
}
