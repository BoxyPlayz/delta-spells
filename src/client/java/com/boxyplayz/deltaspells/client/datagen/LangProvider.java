package com.boxyplayz.deltaspells.client.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

public class LangProvider extends FabricLanguageProvider {

	protected LangProvider(FabricPackOutput packOutput, CompletableFuture<Provider> registryLookup) {
		super(packOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("key.delta_spells.cast_spell", "Cast Spell");
		translationBuilder.add("key.delta_spells.spell_next", "Next Spell");
		translationBuilder.add("key.delta_spells.spell_back", "Previous Spell");
		translationBuilder.add("key.category.delta_spells.delta_spells", "Delta Spells");
	}

}
