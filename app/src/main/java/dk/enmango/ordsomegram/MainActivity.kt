package dk.enmango.ordsomegram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dk.enmango.ordsomegram.RequestListFragment.OnListFragmentInteractionListener
import dk.enmango.ordsomegram.model.Request
import dk.enmango.ordsomegram.services.RequestHandler
import dk.enmango.ordsomegram.services.RequestRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: Request?) {
        Log.d("Navigation", item.toString())
        val action = RequestListFragmentDirections.actionToParams(
            item!!.textToTranslate,
            "Oversat tekst!!",
            item.languageOrigin,
            item.languageTarget)

        findNavController(R.id.nav_host).navigate(action)
    }


    val requestRepo: RequestRepository<Request>? = null
    val requestHandler: RequestHandler? = null

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

        Log.d("MainActivity", "Program started")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

}
