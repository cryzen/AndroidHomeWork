package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = view.findViewById<TextView>(R.id.message)

        view.findViewById<Button>(R.id.send_message_button).setOnClickListener {
            val receiverFragment = ReceiverFragment.newInstance(message.text.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, receiverFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}