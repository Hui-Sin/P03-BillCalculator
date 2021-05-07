package sg.edu.rp.c346.id20018354.p03_billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText amountin;
    EditText pax;
    EditText discount;
    RadioGroup type;
    Button gstcharge;
    Button spliting;
    TextView displaysen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amountin=findViewById(R.id.editTextNumberAmount);
        pax =findViewById(R.id.editTextNumberPax);
        discount=findViewById(R.id.editTextNumberDiscount);
        gstcharge=findViewById(R.id.gstServiceCharge);
        spliting=findViewById(R.id.splitingPayment);
        displaysen=findViewById(R.id.displayTotal);
        type=findViewById(R.id.radioPaymentType);

        System.out.println("text onCreate");

//        gstcharge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                // Code for the action
//                String totala=amountin.getText().toString();
//                String gst=gstcharge.getText().toString();
//                int totals= Integer.parseInt(totala);
//                int gsta=Integer.parseInt(gst);
//                int total=(totals/100)*(100+7);
//            }
//        });
        spliting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                // Code for the action
                String tgst= gstcharge.getText().toString();
                String  discounted=discount.getText().toString();
                String people= pax.getText().toString();
                int tgsts= Integer.parseInt(tgst);
                int numpeople=Integer.parseInt(people);
                int discounts=Integer.parseInt(discounted);
                int totald=tgsts*(100-discounts);
                int splited=tgsts/numpeople;

                String val = String.format("Total Bill: $%.2f\nEach pays $%.2f ", totald,splited);
                int checkedRadioId = type.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.radioButtonPaymentCash){
                    // Write the code when male selected
                    val=val+"in cash";

                } else{
                    // Write the code when female selected
                    val=val+"via PayNow to 912345678";

                        }
                displaysen.setText(val);

            }
        });System.out.println(displaysen.getText().toString());
    }
}