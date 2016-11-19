package edu.rit.dxf7606.buddysystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuddySelectionViewFragment extends Fragment {


    public BuddySelectionViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buddy_selection_view, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.buddy_selection_view_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new buddyAdapter(BuddySelection.getBuddySelection().getContactList()));
        return view;
    }

    private class buddyAdapter extends RecyclerView.Adapter<SelectionViewHolder> {

        private ArrayList<String> mContactList;

        public buddyAdapter(ArrayList<String> contactList){
            mContactList = contactList;
            //mContactList = BuddySelection.getBuddySelection().getContactList();
        }

        @Override
        public SelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.buddy_selection_layout, parent, false);

            return new SelectionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SelectionViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return mContactList.size();
        }
    }

    private class SelectionViewHolder extends RecyclerView.ViewHolder {
        private View notSure;

        public SelectionViewHolder(View itemView){
            super(itemView);
            notSure = itemView;
        }

        public void bind(int position){
            String cName = BuddySelection.getBuddySelection().getContactList().get(position);
            //NOT SURE WHAT TO DO HERE
        }
    }
}
