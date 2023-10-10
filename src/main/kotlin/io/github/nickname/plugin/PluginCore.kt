package io.github.nickname.plugin

import io.github.nickname.plugin.kommand.BasicCommand
import io.github.nickname.plugin.listener.JoinEvent
import io.github.nickname.plugin.utils.AsyncTaskTimer
import io.github.nickname.plugin.utils.RegisterListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class PluginCore: JavaPlugin() {
    companion object {
        lateinit var instance: PluginCore
            private set
    }

    override fun onEnable() {
        logger.info("Template1CorePlugin was Enabled!")
        instance = this

        RegisterListener.listeners(JoinEvent())

        BasicCommand(this)
        val timer = AsyncTaskTimer(this)
        timer.asyncTaskTimer {
            var times = 0
            delay(0L)
            period(20 * 5 * 60L)
            run {
                logger.info("서버가 켜진지 ${times}분 지났습니다.")
                times += 5

                //이 부분은 제거해도 됩니다.
                if (times == 60) {
                    logger.info("서버가 켜진지 1시간이 지나 서버가 자동 죵료됩니다.")
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop")
                }
            }
            cancelTaskIf {
                times == 60
            }
        }.exec()
    }
}