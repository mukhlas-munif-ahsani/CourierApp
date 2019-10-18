package com.tiunida.courierapp.FragmentKilat.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.tiunida.courierapp.FragmentExpress.Adapter.ExpressAdapter;
import com.tiunida.courierapp.FragmentKilat.Model.KilatModel;
import com.tiunida.courierapp.R;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KilatAdapter extends FirestoreRecyclerAdapter<KilatModel, KilatAdapter.Holder> {

    private OnItemClickListener listener;

    public KilatAdapter(@NonNull FirestoreRecyclerOptions<KilatModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Holder holder, int i, @NonNull KilatModel kilatModel) {
        holder.mNameTxt.setText(kilatModel.getA_name());
        holder.mDormitoryTxt.setText(kilatModel.getA_dormitory());
        holder.mRoomTxt.setText(kilatModel.getA_room());
        holder.mDoneTimeTxt.setText(kilatModel.getA_waktu_selesai());

        //orderHolder.mjenis.setText(model.getA_jenis());
        if (kilatModel.getA_price2() != null) {
            Log.d("tidak ", "null");
            int priceInt = Integer.valueOf(kilatModel.getA_price2());
            int diskonInt = Integer.valueOf(kilatModel.getA_diskon());
            int hasil = priceInt * diskonInt / 100;
            int totalPrice = priceInt - hasil;
            holder.mPrice.setText(String.valueOf(totalPrice));
        }

        //orderHolder.mPrice.setText(model.getA_price2());

        String string1 = "1";
        if (kilatModel.getH_accepted2().equals(string1)) {
            holder.mAcceptIndicator.setBackgroundResource(R.drawable.circle_view_background);
            holder.mAcceptedLine.setBackgroundResource(R.drawable.rectangle_view_bacground);
        } else {
            holder.mAcceptIndicator.setBackgroundResource(R.drawable.circle_view_border);
            holder.mAcceptedLine.setBackgroundResource(R.drawable.rectangle_view_border);
        }

        if (kilatModel.getH_on_proses2().equals(string1)) {
            holder.mProsesIndicator.setBackgroundResource(R.drawable.circle_view_background);
            holder.mProsesLine.setBackgroundResource(R.drawable.rectangle_view_bacground);
        } else {
            holder.mProsesIndicator.setBackgroundResource(R.drawable.circle_view_border);
            holder.mProsesLine.setBackgroundResource(R.drawable.rectangle_view_border);
        }

        if (kilatModel.getH_done2().equals(string1)) {
            holder.mDoneIndicator.setBackgroundResource(R.drawable.circle_view_background);
            holder.mDoneLine.setBackgroundResource(R.drawable.rectangle_view_bacground);
        } else {
            holder.mDoneIndicator.setBackgroundResource(R.drawable.circle_view_border);
            holder.mDoneLine.setBackgroundResource(R.drawable.rectangle_view_border);
        }

        if (kilatModel.getH_paid2().equals(string1) && kilatModel.getH_paid2Confirm().equals(string1)) {
            holder.mPaindIndicator.setBackgroundResource(R.drawable.circle_view_background);
            holder.mPaidLine.setBackgroundResource(R.drawable.rectangle_view_bacground);
        } else {
            holder.mPaindIndicator.setBackgroundResource(R.drawable.circle_view_border);
            holder.mPaidLine.setBackgroundResource(R.drawable.rectangle_view_border);
        }

        if (kilatModel.getH_delivered2().equals(string1) && kilatModel.getH_delivered2Confirm().equals(string1)) {
            holder.mDeliveredIndicator.setBackgroundResource(R.drawable.circle_view_background);
        } else {
            holder.mDeliveredIndicator.setBackgroundResource(R.drawable.circle_view_border);
        }

        switch (kilatModel.getA_weight()) {
            case "1":
                holder.mPrice.setText(setTotalPrice(8000, kilatModel.getA_diskon()));
                break;
            case "1.1":
                holder.mPrice.setText(setTotalPrice(8800, kilatModel.getA_diskon()));
                break;
            case "1.2":
                holder.mPrice.setText(setTotalPrice(9600, kilatModel.getA_diskon()));
                break;
            case "1.3":
                holder.mPrice.setText(setTotalPrice(10400, kilatModel.getA_diskon()));
                break;
            case "1.4":
                holder.mPrice.setText(setTotalPrice(11200, kilatModel.getA_diskon()));
                break;
            case "1.5":
                holder.mPrice.setText(setTotalPrice(12000, kilatModel.getA_diskon()));
                break;
            case "1.6":
                holder.mPrice.setText(setTotalPrice(12800, kilatModel.getA_diskon()));
                break;
            case "1.7":
                holder.mPrice.setText(setTotalPrice(13600, kilatModel.getA_diskon()));
                break;
            case "1.8":
                holder.mPrice.setText(setTotalPrice(14400, kilatModel.getA_diskon()));
                break;
            case "1.9":
                holder.mPrice.setText(setTotalPrice(15200, kilatModel.getA_diskon()));
                break;
            //-2---------------
            case "2":
                holder.mPrice.setText(setTotalPrice(16000, kilatModel.getA_diskon()));
                break;
            case "2.1":
                holder.mPrice.setText(setTotalPrice(16800, kilatModel.getA_diskon()));
                break;
            case "2.2":
                holder.mPrice.setText(setTotalPrice(17600, kilatModel.getA_diskon()));
                break;
            case "2.3":
                holder.mPrice.setText(setTotalPrice(18400, kilatModel.getA_diskon()));
                break;
            case "2.4":
                holder.mPrice.setText(setTotalPrice(19200, kilatModel.getA_diskon()));
                break;
            case "2.5":
                holder.mPrice.setText(setTotalPrice(20000, kilatModel.getA_diskon()));
                break;
            case "2.6":
                holder.mPrice.setText(setTotalPrice(20800, kilatModel.getA_diskon()));
                break;
            case "2.7":
                holder.mPrice.setText(setTotalPrice(21600, kilatModel.getA_diskon()));
                break;
            case "2.8":
                holder.mPrice.setText(setTotalPrice(22400, kilatModel.getA_diskon()));
                break;
            case "2.9":
                holder.mPrice.setText(setTotalPrice(23200, kilatModel.getA_diskon()));
                break;
            //-3---------------
            case "3":
                holder.mPrice.setText(setTotalPrice(24000, kilatModel.getA_diskon()));
                break;
            case "3.1":
                holder.mPrice.setText(setTotalPrice(24800, kilatModel.getA_diskon()));
                break;
            case "3.2":
                holder.mPrice.setText(setTotalPrice(25600, kilatModel.getA_diskon()));
                break;
            case "3.3":
                holder.mPrice.setText(setTotalPrice(26400, kilatModel.getA_diskon()));
                break;
            case "3.4":
                holder.mPrice.setText(setTotalPrice(27200, kilatModel.getA_diskon()));
                break;
            case "3.5":
                holder.mPrice.setText(setTotalPrice(28000, kilatModel.getA_diskon()));
                break;
            case "3.6":
                holder.mPrice.setText(setTotalPrice(28800, kilatModel.getA_diskon()));
                break;
            case "3.7":
                holder.mPrice.setText(setTotalPrice(29600, kilatModel.getA_diskon()));
                break;
            case "3.8":
                holder.mPrice.setText(setTotalPrice(30400, kilatModel.getA_diskon()));
                break;
            case "3.9":
                holder.mPrice.setText(setTotalPrice(31200, kilatModel.getA_diskon()));
                break;
            //-4---------------
            case "4":
                holder.mPrice.setText(setTotalPrice(32000, kilatModel.getA_diskon()));
                break;
            case "4.1":
                holder.mPrice.setText(setTotalPrice(32800, kilatModel.getA_diskon()));
                break;
            case "4.2":
                holder.mPrice.setText(setTotalPrice(33600, kilatModel.getA_diskon()));
                break;
            case "4.3":
                holder.mPrice.setText(setTotalPrice(33400, kilatModel.getA_diskon()));
                break;
            case "4.4":
                holder.mPrice.setText(setTotalPrice(34200, kilatModel.getA_diskon()));
                break;
            case "4.5":
                holder.mPrice.setText(setTotalPrice(35000, kilatModel.getA_diskon()));
                break;
            case "4.6":
                holder.mPrice.setText(setTotalPrice(35800, kilatModel.getA_diskon()));
                break;
            case "4.7":
                holder.mPrice.setText(setTotalPrice(36600, kilatModel.getA_diskon()));
                break;
            case "4.8":
                holder.mPrice.setText(setTotalPrice(37400, kilatModel.getA_diskon()));
                break;
            case "4.9":
                holder.mPrice.setText(setTotalPrice(38200, kilatModel.getA_diskon()));
                break;
            //-5---------------
            case "5":
                holder.mPrice.setText(setTotalPrice(39000, kilatModel.getA_diskon()));
                break;
            case "5.1":
                holder.mPrice.setText(setTotalPrice(39800, kilatModel.getA_diskon()));
                break;
            case "5.2":
                holder.mPrice.setText(setTotalPrice(40600, kilatModel.getA_diskon()));
                break;
            case "5.3":
                holder.mPrice.setText(setTotalPrice(41400, kilatModel.getA_diskon()));
                break;
            case "5.4":
                holder.mPrice.setText(setTotalPrice(42200, kilatModel.getA_diskon()));
                break;
            case "5.5":
                holder.mPrice.setText(setTotalPrice(43000, kilatModel.getA_diskon()));
                break;
            case "5.6":
                holder.mPrice.setText(setTotalPrice(43800, kilatModel.getA_diskon()));
                break;
            case "5.7":
                holder.mPrice.setText(setTotalPrice(44600, kilatModel.getA_diskon()));
                break;
            case "5.8":
                holder.mPrice.setText(setTotalPrice(45400, kilatModel.getA_diskon()));
                break;
            case "5.9":
                holder.mPrice.setText(setTotalPrice(46200, kilatModel.getA_diskon()));
                break;
            //-6---------------
            case "6":
                holder.mPrice.setText(setTotalPrice(47000, kilatModel.getA_diskon()));
                break;
            case "6.1":
                holder.mPrice.setText(setTotalPrice(47800, kilatModel.getA_diskon()));
                break;
            case "6.2":
                holder.mPrice.setText(setTotalPrice(48600, kilatModel.getA_diskon()));
                break;
            case "6.3":
                holder.mPrice.setText(setTotalPrice(49400, kilatModel.getA_diskon()));
                break;
            case "6.4":
                holder.mPrice.setText(setTotalPrice(50200, kilatModel.getA_diskon()));
                break;
            case "6.5":
                holder.mPrice.setText(setTotalPrice(51000, kilatModel.getA_diskon()));
                break;
            case "6.6":
                holder.mPrice.setText(setTotalPrice(51800, kilatModel.getA_diskon()));
                break;
            case "6.7":
                holder.mPrice.setText(setTotalPrice(52600, kilatModel.getA_diskon()));
                break;
            case "6.8":
                holder.mPrice.setText(setTotalPrice(53400, kilatModel.getA_diskon()));
                break;
            case "6.9":
                holder.mPrice.setText(setTotalPrice(54200, kilatModel.getA_diskon()));
                break;
            //-7---------------
            case "7":
                holder.mPrice.setText(setTotalPrice(55000, kilatModel.getA_diskon()));
                break;
            case "7.1":
                holder.mPrice.setText(setTotalPrice(55800, kilatModel.getA_diskon()));
                break;
            case "7.2":
                holder.mPrice.setText(setTotalPrice(56600, kilatModel.getA_diskon()));
                break;
            case "7.3":
                holder.mPrice.setText(setTotalPrice(57400, kilatModel.getA_diskon()));
                break;
            case "7.4":
                holder.mPrice.setText(setTotalPrice(58200, kilatModel.getA_diskon()));
                break;
            case "7.5":
                holder.mPrice.setText(setTotalPrice(59000, kilatModel.getA_diskon()));
                break;
            case "7.6":
                holder.mPrice.setText(setTotalPrice(59800, kilatModel.getA_diskon()));
                break;
            case "7.7":
                holder.mPrice.setText(setTotalPrice(60600, kilatModel.getA_diskon()));
                break;
            case "7.8":
                holder.mPrice.setText(setTotalPrice(61400, kilatModel.getA_diskon()));
                break;
            case "7.9":
                holder.mPrice.setText(setTotalPrice(62200, kilatModel.getA_diskon()));
                break;
            //-8---------------
            case "8":
                holder.mPrice.setText(setTotalPrice(63000, kilatModel.getA_diskon()));
                break;
            case "8.1":
                holder.mPrice.setText(setTotalPrice(63800, kilatModel.getA_diskon()));
                break;
            case "8.2":
                holder.mPrice.setText(setTotalPrice(64600, kilatModel.getA_diskon()));
                break;
            case "8.3":
                holder.mPrice.setText(setTotalPrice(65400, kilatModel.getA_diskon()));
                break;
            case "8.4":
                holder.mPrice.setText(setTotalPrice(66200, kilatModel.getA_diskon()));
                break;
            case "8.5":
                holder.mPrice.setText(setTotalPrice(67000, kilatModel.getA_diskon()));
                break;
            case "8.6":
                holder.mPrice.setText(setTotalPrice(67800, kilatModel.getA_diskon()));
                break;
            case "8.7":
                holder.mPrice.setText(setTotalPrice(68600, kilatModel.getA_diskon()));
                break;
            case "8.8":
                holder.mPrice.setText(setTotalPrice(69400, kilatModel.getA_diskon()));
                break;
            case "8.9":
                holder.mPrice.setText(setTotalPrice(70200, kilatModel.getA_diskon()));
                break;
            //-9---------------
            case "9":
                holder.mPrice.setText(setTotalPrice(71000, kilatModel.getA_diskon()));
                break;
            case "9.1":
                holder.mPrice.setText(setTotalPrice(71800, kilatModel.getA_diskon()));
                break;
            case "9.2":
                holder.mPrice.setText(setTotalPrice(72600, kilatModel.getA_diskon()));
                break;
            case "9.3":
                holder.mPrice.setText(setTotalPrice(73400, kilatModel.getA_diskon()));
                break;
            case "9.4":
                holder.mPrice.setText(setTotalPrice(74200, kilatModel.getA_diskon()));
                break;
            case "9.5":
                holder.mPrice.setText(setTotalPrice(75000, kilatModel.getA_diskon()));
                break;
            case "9.6":
                holder.mPrice.setText(setTotalPrice(75800, kilatModel.getA_diskon()));
                break;
            case "9.7":
                holder.mPrice.setText(setTotalPrice(76600, kilatModel.getA_diskon()));
                break;
            case "9.8":
                holder.mPrice.setText(setTotalPrice(77400, kilatModel.getA_diskon()));
                break;
            case "9.9":
                holder.mPrice.setText(setTotalPrice(78200, kilatModel.getA_diskon()));
                break;
        }
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_order, parent, false);
        return new Holder(view);
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.doneTime)
        TextView mDoneTimeTxt;
        @BindView(R.id.nameTxt)
        TextView mNameTxt;
        @BindView(R.id.dormitoryTxt)
        TextView mDormitoryTxt;
        @BindView(R.id.roomTxt)
        TextView mRoomTxt;
        @BindView(R.id.price)
        TextView mPrice;
        @BindView(R.id.acceptIndicator)
        View mAcceptIndicator;
        @BindView(R.id.acceptLine)
        View mAcceptedLine;
        @BindView(R.id.prosesIndicator)
        View mProsesIndicator;
        @BindView(R.id.prosesLine)
        View mProsesLine;
        @BindView(R.id.doneIndicator)
        View mDoneIndicator;
        @BindView(R.id.doneLine)
        View mDoneLine;
        @BindView(R.id.paidIndicator)
        View mPaindIndicator;
        @BindView(R.id.paidLine)
        View mPaidLine;
        @BindView(R.id.deliveredIndicator)
        View mDeliveredIndicator;

        public Holder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posision = getAdapterPosition();
                    if (posision != RecyclerView.NO_POSITION && listener != null) {
                        listener.onKilatItemClick(getSnapshots().getSnapshot(posision), posision);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onKilatItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public String setTotalPrice(int price, String diskon) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        int priceInt;
        int disokonInt = Integer.valueOf(diskon);
        int hasil;
        int totalPrice;
        priceInt = price;
        hasil = priceInt * disokonInt / 100;
        totalPrice = priceInt - hasil;
        return formatter.format(totalPrice);
    }
}
