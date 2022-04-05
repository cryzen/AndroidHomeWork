package com.example.androidhomework

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ReceiverFragment : Fragment() {

    private lateinit var receiverMessage: TextView
    private lateinit var viewModel: ReceiverViewModel

    companion object {
        private const val MESSAGE_KEY = "MESSAGE_KEY"

        fun newInstance(textMessage: String): Fragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putString(MESSAGE_KEY, textMessage)
                arguments = bundle
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ReceiverViewModel::class.java)

        viewModel.messageLiveData.observe(viewLifecycleOwner) { message ->
            receiverMessage.text = message
        }

        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        receiverMessage = view.findViewById(R.id.receiver_message)
        val textMessage = arguments?.getString(MESSAGE_KEY)
        receiverMessage.text = textMessage

        view.findViewById<Button>(R.id.read_button).setOnClickListener {
            receiverMessage.setText(R.string.read_messages)
            viewModel.addMessage(receiverMessage.text.toString())
        }
    }

}