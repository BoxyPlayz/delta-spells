package com.boxyplayz.deltaspells.mixin;

import net.fabricmc.fabric.api.attachment.v1.GlobalAttachmentsProvider;
import net.fabricmc.fabric.api.resource.v1.DataResourceStore;
import net.minecraft.commands.CommandSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerInfo;
import net.minecraft.server.TickTask;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import net.minecraft.world.level.chunk.storage.ChunkIOErrorReporter;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
abstract public class ExampleMixin extends ReentrantBlockableEventLoop<TickTask>
		implements CommandSource, ServerInfo, ChunkIOErrorReporter, GlobalAttachmentsProvider, DataResourceStore {
	public ExampleMixin(String name, boolean propagatesCrashes) {
		super(name, propagatesCrashes);
	}

	@Inject(at = @At("HEAD"), method = "loadLevel")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadLevel()V
	}
}