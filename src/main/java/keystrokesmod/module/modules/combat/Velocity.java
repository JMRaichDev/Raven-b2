//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mappings-1.8.9"!

// 
// Decompiled by Procyon v0.5.36
// 

package keystrokesmod.module.modules.combat;

import keystrokesmod.module.modules.client.SelfDestruct;
import keystrokesmod.module.Module;
import keystrokesmod.module.ModuleHelper;
import keystrokesmod.module.ModuleSettings2;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.event.entity.living.LivingEvent;

public class Velocity extends Module
{
    public static ModuleSettings2 horizontal;
    public static ModuleSettings2 vertical;
    public static ModuleSettings2 chance;
    
    public Velocity() {
        super(new char[] { 'V', 'e', 'l', 'o', 'c', 'i', 't', 'y' }, category.combat, 0);
        this.registerSetting(Velocity.horizontal = new ModuleSettings2(new char[] { 'H', 'o', 'r', 'i', 'z', 'o', 'n', 't', 'a', 'l' }, 96.0, 0.0, 100.0, 1.0));
        this.registerSetting(Velocity.vertical = new ModuleSettings2(new char[] { 'V', 'e', 'r', 't', 'i', 'c', 'a', 'l' }, 100.0, 0.0, 100.0, 1.0));
        this.registerSetting(Velocity.chance = new ModuleSettings2(new char[] { 'C', 'h', 'a', 'n', 'c', 'e' }, 100.0, 0.0, 100.0, 1.0));
    }
    
    @SubscribeEvent
    public void c(final LivingEvent.LivingUpdateEvent d) {
        if (ModuleHelper.e() && !SelfDestruct.isDestructed && Velocity.mc.thePlayer.hurtTime == Velocity.mc.thePlayer.maxHurtTime && Velocity.mc.thePlayer.maxHurtTime > 0) {
            final double ch = Math.random();
            if (ch < Velocity.chance.getInput() / 100.0) {
                final EntityPlayerSP thePlayer = Velocity.mc.thePlayer;
                thePlayer.motionX *= Velocity.horizontal.getInput() / 100.0;
                final EntityPlayerSP thePlayer2 = Velocity.mc.thePlayer;
                thePlayer2.motionY *= Velocity.vertical.getInput() / 100.0;
                final EntityPlayerSP thePlayer3 = Velocity.mc.thePlayer;
                thePlayer3.motionZ *= Velocity.horizontal.getInput() / 100.0;
            }
        }
    }
}
