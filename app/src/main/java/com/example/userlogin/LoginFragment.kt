package com.example.userlogin

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.userlogin.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var homeFragment: HomeFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        homeFragment = HomeFragment()
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginBtn.setOnClickListener {
            viewModel.username = binding.userName.text.toString()
            var value = viewModel.checkUserEmail()
            if (value) {
                Toast.makeText(activity, "Email  verified", Toast.LENGTH_SHORT).show()
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragment_container,homeFragment)
                    commit()
                }
            } else {
                Toast.makeText(activity, "Email not verified", Toast.LENGTH_SHORT).show()

            }
        }

        return binding.root
    }


}