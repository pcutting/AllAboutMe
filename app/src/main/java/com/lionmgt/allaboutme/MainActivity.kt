package com.lionmgt.allaboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.lionmgt.allaboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationBar.setOnNavigationItemReselectedListener {
            handleBottomNavigationBar(it.itemId)
        }

    }

    private fun handleBottomNavigationBar(menuItemId: Int
    ): Boolean = when (menuItemId) {
        R.id.menu_bio -> {
            swapFragments(BioFragment())
            true
        }
        R.id.menu_family -> {
            swapFragments(FamilyFragment())
            true
        }
        R.id.menu_hobbies -> {
            swapFragments(HobbiesFragment())
            true
        }
        else -> false
    }

    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_container, fragment)
            .commit()

    }


}