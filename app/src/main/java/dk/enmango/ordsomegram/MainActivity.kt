package dk.enmango.ordsomegram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.model.RequestListFragment
import dk.enmango.ordsomegram.services.IRequestRepository
import dk.enmango.ordsomegram.services.RequestRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity(), RequestListFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: Request?) {
        val args = Bundle()
        args.putString("param1", "Selected")
        args.putString("param2", item.toString())
        findNavController(R.id.nav_host).navigate(R.id.request_dest, args)
    }

    val requestRepo: RequestRepository = RequestRepository()
    val requestHandler: RequestHandler = RequestHandler(requestRepo)

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
                findNavController(R.id.nav_host).navigate(R.id.requestAnswer_dest)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }
        Log.d("MainActivity", "Program started")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}
