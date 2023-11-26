package de.duckulus.labydojofix.mixins;

import de.duckulus.labydojofix.LabyDojoFix;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
    @Inject(
            at = @At("HEAD"),
            method = "sendPacket(Lnet/minecraft/network/Packet;)V",
            cancellable = true
    )
    public void onPacketSend(Packet packet, CallbackInfo ci) {
        if (packet instanceof C17PacketCustomPayload) {
            C17PacketCustomPayload pluginMessagePacket = (C17PacketCustomPayload) packet;
            String channelName = pluginMessagePacket.getChannelName();
            if (channelName.length() > 16) {
                LabyDojoFix.LOGGER.info(String.format("Cancelled plugin message on channel [%s] (Length: %d)", channelName, channelName.length()));
                ci.cancel();
            }
        }
    }

}
