package com.caffeine.swingit

import com.caffeine.swingit.Graphics.GInterval
import com.caffeine.swingit.Graphics.GPoint
import com.caffeine.swingit.Graphics.IGUpdatable

class EnnemiesGenerator(val scene: GameScene) : IGUpdatable
{
    val screenHeightUsable: Float
    val positionInterval: GInterval
    var lastGenerationTime: Long = 0L

    init {
        screenHeightUsable = scene.size.height - scene.terrain.terrainHeightPixel
        positionInterval = GInterval(0f, screenHeightUsable)
    }


    override fun update(currentTime: Long)
    {
        if(currentTime - lastGenerationTime > scene.timelapseItemGeneration) {
            if(GInterval.random(0f, 1f) > GameScene.ennemyProbability) return
            lastGenerationTime = currentTime
            scene.addChild(Ennemy(scene,
                    GPoint(scene.size.width + scene.CHARACTER_SIZE.width,
                            positionInterval.random())
            ))
        }
    }
}