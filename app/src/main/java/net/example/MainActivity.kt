package net.example

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import net.example.dialog.LockDialogFragment
import net.example.pager.OnPagerAdapterCallback
import net.example.pager.PagerAdapter
import net.example.pager.TabItem
import net.example.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity(), OnPagerAdapterCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = PagerAdapter(supportFragmentManager, this)
        tabs.setupWithViewPager(view_pager)
        view_pager.adapter = adapter


        val items: MutableList<TabItem> = mutableListOf()
        items.add(TabItem(id = 1, name = "Breakfast"))
        items.add(TabItem(id = 2, name = "Lunch"))
        items.add(TabItem(id = 3, name = "Dinner"))
        items.add(TabItem(id = 4, name = "Popular"))
        items.add(TabItem(id = 5, name = "Protein"))
        items.add(TabItem(id = 5, name = "Main Dishes"))

        adapter.items = items


        iv_add_recipe.setOnClickListener {
            val dialog = LockDialogFragment()
            dialog.showNow(supportFragmentManager, null)
        }

    }

    override fun getItem(item: TabItem?, position: Int): Fragment = DashboardFragment()
}
