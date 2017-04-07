package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.NonReadablePropertyException
import co.zsmb.materialdrawerkt.draweritems.ProfileDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder

class AccountHeaderBuilderKt(activity: Activity) {

    private val builder = AccountHeaderBuilder()

    init {
        builder.withActivity(activity)
    }

    var background: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    fun profile(name: String = "", email: String = "", setup: ProfileDrawerItemKt.() -> Unit = {}) {
        val item = ProfileDrawerItemKt(name, email)
        item.setup()
        builder.addProfiles(item.build())
    }

    internal fun build(): AccountHeader = builder.build()

}
