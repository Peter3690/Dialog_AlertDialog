package tulv.dialog_alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowDialog, btnShowAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        setEvent();
    }

    public void getWidget() {
        btnShowAlertDialog = (Button) findViewById(R.id.btn_show_alertDialog);
        btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
    }

    public void setEvent() {
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        // build a dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message...");
        builder.setMessage("Are you ready?");
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You are agree...", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        //init alertdialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Message");
        //set when click outside dialog: if "true" then hide and otherwise
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);
        Button btnYes = (Button) dialog.findViewById(R.id.btn_yes);
        Button btnNo = (Button) dialog.findViewById(R.id.btn_no);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You Agree!", Toast.LENGTH_SHORT).show();
                //hide dialog
                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hide dialog
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
