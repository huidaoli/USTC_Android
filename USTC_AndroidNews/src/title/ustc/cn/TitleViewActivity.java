package title.ustc.cn;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import content.ustc.cn.NewsContentActivity;
import title.ustc.cn.R;
public class TitleViewActivity extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//�̳и��෽��
		setListAdapter(new ArrayAdapter<String>(this, R.layout.titles_ustc,
				NewsTitleActivity.GetNewsTitleList()));// ����Adapter������
		ListView titlesUI = getListView();// ���ļ�xml�ļ�������ListView
		titlesUI.setTextFilterEnabled(true);
		titlesUI.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,   
				int position,long id) {
			setListAdapter(new ArrayAdapter<String>(TitleViewActivity.this, R.layout.titles_ustc,
					 NewsContentActivity.GetNewsConList((int)id)));
			ListView contentUI = getListView();// ���ļ�xml�ļ�������ListView
			contentUI.setTextFilterEnabled(true);
		}
		});
	}
}
