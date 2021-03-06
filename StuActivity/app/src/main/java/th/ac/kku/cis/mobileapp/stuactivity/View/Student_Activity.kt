package th.ac.kku.cis.mobileapp.stuactivity.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_admin_main.*
import th.ac.kku.cis.mobileapp.stuactivity.R

class Student_Activity : AppCompatActivity(){
    lateinit var auth: FirebaseAuth
    lateinit var googleClient: GoogleSignInClient
    var boo: Boolean = false
    private val PERMISSION_CODE = 1000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_student_main)

            }
        }
    }
    private fun firebaseAuth(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    boo = true

            var i = Intent(this, Save_Activity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
    }
    private fun passproject() {
        if (boo) {
            var i = Intent(this, MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
    }
    private fun singOut() {

        auth.signOut()
        boo = true
        passproject()
    }
}