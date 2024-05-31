package com.example.myquatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myquatsapp.databinding.ActivityMainBinding
import com.example.myquatsapp.databinding.FragmentProfileBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeFragment = HomeFragment()
        loadFragment(homeFragment)
        initDrawebalManu()
        binding.bottomappbar.background = null
        bottomNavigation()

    }

    private fun bottomNavigation() {

        binding.bottomappbar.setNavigationOnClickListener{
            when (it.id) {
                R.id.bottom_save -> {
                    loadFragment(SaveFragment())
                    true
                }

                R.id.bottom_home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.bottom_profile -> {
//                   val intent = Intent(this, ProfileFragment::class.java)
//                    startActivity(intent)
                    loadFragment(ProfileFragment())
                    true
                }

                else -> false

            }
        }
    }

    @SuppressLint("WrongConstant")
    private fun initDrawebalManu() {
        binding.btnMenu.setOnClickListener {
            binding.main.openDrawer(Gravity.START)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentTranfer = supportFragmentManager.beginTransaction()
        fragmentTranfer.replace(R.id.fragmentfram, fragment)
        fragmentTranfer.addToBackStack(null)
        fragmentTranfer.commit()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        binding.navigationDrawer.setNavigationItemSelectedListener {
            when (p0.itemId) {
                R.id.mshare -> {
                    binding.main.closeDrawer(GravityCompat.START)
                    Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mrate -> {
                    Toast.makeText(this, "Ratting", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mtheme -> {
                    Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mset -> {
                    Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mstarred -> {
                    Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mset -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                    true
                }


                else -> {
                    false
                }
            }

        }
        return true
    }
}


                


