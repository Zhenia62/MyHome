package com.example.teleg.myhome.RestActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teleg.myhome.Complaint.Complaint;
import com.example.teleg.myhome.Complaint.ComplaintAdapter;
import com.example.teleg.myhome.EditProfileActivity;
import com.example.teleg.myhome.MainActivity;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.Tape.Tape;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.teleg.myhome.MainActivity.slidingRootNav;

public class MainProfile extends AppCompatActivity implements View.OnClickListener {

    private final int Pick_image = 1;
    //public static int count = 1;

    public static final String Name = "Евгений";
    public static final String SecondName = "Телегин";

    public ArrayList<Tape> tapes = new ArrayList<>();


    ListView listView;
    ImageView imageView;
    ImageView imageVieMain;
    ImageView imageViewPhoto;

    Toolbar toolbar;

    TextView name;
    TextView secondName;

    Button editUser, menu;

    RecyclerView recycleView;

    EditText title;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);


        tapes.clear();

        String[] Items = getResources().getStringArray(R.array.profile);

        listView = findViewById(R.id.listViewP);
        imageView = findViewById(R.id.backAct);
        imageViewPhoto = findViewById(R.id.new_photo);
        imageVieMain = findViewById(R.id.main_view);


        name = findViewById(R.id.textName);
        secondName = findViewById(R.id.textSecondName);

        name.setText(Name);
        secondName.setText(SecondName);

        editUser = findViewById(R.id.edit);
        editUser.setOnClickListener(this);

        title = findViewById(R.id.TapeTile);
        message = findViewById(R.id.TapeText);

        recycleView = (RecyclerView) findViewById(R.id.TapeListMainProf);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Complaint> complaints = new ArrayList<>();

        complaints.add(new Complaint(R.drawable.caution_ico,
                "Самовольный захват муниципальной земли путём возведения забора.",
                "Строительство",
                "Жалоба",
                "Принято к исполнению",
                "Россия, Рязань, улица Пугачёва, 109",
                "Нарушения при строительстве",
                "Застройщиком ООО \"РТС\" заканчивается строительство многоквартирного дома \"ЖК СМАРТ дом на Славянском проспекте\", имеющий строительный адрес г.Рязань ул.Пугачева №109. Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора. Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. По предварительной оценке, самовольно занято будет примерно пол гектара муниципальной земли. Ограждение будет мешать всем жителям близлежащих домов. Прошу проверить границы и законность установки забора вокруг участка с кадастровым номером 62:29:0090030:643 . В случае выявления нарушений, привлечь застройщика ООО \"РТС\" к ответственности согласно статьи 7.1 КоАП РФ. \"КоАП РФ Статья 7.1."));

        complaints.add(new Complaint(R.drawable.caution_ico,
                "Самовольный захват муниципальной земли путём возведения забора.",
                "Строительство",
                "Жалоба",
                "Принято к исполнению",
                "Россия, Рязань, улица Пугачёва, 109",
                "Нарушения при строительстве",
                "Застройщиком ООО \"РТС\" заканчивается строительство многоквартирного дома \"ЖК СМАРТ дом на Славянском проспекте\", имеющий строительный адрес г.Рязань ул.Пугачева №109. Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора. Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. По предварительной оценке, самовольно занято будет примерно пол гектара муниципальной земли. Ограждение будет мешать всем жителям близлежащих домов. Прошу проверить границы и законность установки забора вокруг участка с кадастровым номером 62:29:0090030:643 . В случае выявления нарушений, привлечь застройщика ООО \"РТС\" к ответственности согласно статьи 7.1 КоАП РФ. \"КоАП РФ Статья 7.1."));

        complaints.add(new Complaint(R.drawable.caution_ico,
                "Самовольный захват муниципальной земли путём возведения забора.",
                "Строительство",
                "Жалоба",
                "Принято к исполнению",
                "Россия, Рязань, улица Пугачёва, 109",
                "Нарушения при строительстве",
                "Застройщиком ООО \"РТС\" заканчивается строительство многоквартирного дома \"ЖК СМАРТ дом на Славянском проспекте\", имеющий строительный адрес г.Рязань ул.Пугачева №109. Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора. Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. По предварительной оценке, самовольно занято будет примерно пол гектара муниципальной земли. Ограждение будет мешать всем жителям близлежащих домов. Прошу проверить границы и законность установки забора вокруг участка с кадастровым номером 62:29:0090030:643 . В случае выявления нарушений, привлечь застройщика ООО \"РТС\" к ответственности согласно статьи 7.1 КоАП РФ. \"КоАП РФ Статья 7.1."));

        ComplaintAdapter complaintAdapter = new ComplaintAdapter(complaints);
        recycleView.setAdapter(complaintAdapter);



        imageView.setOnClickListener(this);
        imageViewPhoto.setOnClickListener(this);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Items);
        listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int value = position;

            switch (value) {
                case 0:
                    //Intent intent0 = new Intent(MainProfile.this, MyDiscussionsActivity.class);
                    //startActivity(intent0);
                    break;
            }
        }
    });
}

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backAct:
                finish();
                break;
            case R.id.new_photo:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
                break;
            case R.id.edit:
                Intent editInformation = new Intent(this, EditProfileActivity.class);
                startActivity(editInformation);
                break;
            case R.id.addList:
                break;
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageVieMain.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
