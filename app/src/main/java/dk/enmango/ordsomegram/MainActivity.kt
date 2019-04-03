package dk.enmango.ordsomegram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.appModule
import dk.enmango.ordsomegram.ui.AnswersFragment
import dk.enmango.ordsomegram.ui.RequestListFragment
import dk.enmango.ordsomegram.ui.RequestListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity(), AnswersFragment.OnAnswerListFragmentInteractionListener,
    RequestListFragment.OnListFragmentInteractionListener {
    override fun onAnswerListFragmentInteraction(item: Request?) {
        Log.d("Navigation", item.toString())
    }

    override fun onListFragmentInteraction(item: Request?) {
        Log.d("Navigation", item.toString())
        val action = RequestListFragmentDirections.actionToParams(
            item!!.id!!)

        findNavController(R.id.nav_host).navigate(action)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_requests -> {
                findNavController(R.id.nav_host).navigate(R.id.request_dest)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_answered_requests -> {
                findNavController(R.id.nav_host).navigate(R.id.request_list_dest)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_send_answers -> {
                findNavController(R.id.nav_host).navigate(R.id.answers_dest)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // start Koin!

        startKoin {
            // Android context
            androidContext(this@MainActivity)
            // modules
            modules(appModule)
        }
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Program started")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

}
