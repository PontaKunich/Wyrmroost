package WolfShotz.Wyrmroost;

import WolfShotz.Wyrmroost.content.world.dimension.WyrmroostDimension;
import WolfShotz.Wyrmroost.registry.*;
import WolfShotz.Wyrmroost.util.ConfigData;
import WolfShotz.Wyrmroost.util.ModUtils;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod(Wyrmroost.MOD_ID)
public class Wyrmroost
{
    public static final String MOD_ID = "wyrmroost";
    public static final ItemGroup CREATIVE_TAB = ModUtils.itemGroupFactory("wyrmroost", () -> new ItemStack(WRItems.BLUE_GEODE.get()));
    public static final SimpleChannel NETWORK = ModUtils.simplisticChannel(rl(MOD_ID), "1.0");
    
    public Wyrmroost()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CommonEvents.onModConstruction(eventBus);

        WREntities.ENTITIES.register(eventBus);
        WRBlocks.BLOCKS.register(eventBus);
        WRItems.ITEMS.register(eventBus);
        WRFluids.FLUIDS.register(eventBus);
        WRIO.CONTAINERS.register(eventBus);
        WRSounds.SOUNDS.register(eventBus);
        WRBiomes.BIOMES.register(eventBus);
        WRWorld.FEATURES.register(eventBus);
        eventBus.addGenericListener(ModDimension.class, (RegistryEvent.Register<ModDimension> e) -> e.getRegistry().register(ModDimension.withFactory(WyrmroostDimension::new).setRegistryName("wyrmroost")));

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigData.CommonConfig.COMMON_SPEC);
    }

    /**
     * Register a new Wyrmroost Specific Resource Location.
     */
    public static ResourceLocation rl(String path) { return new ResourceLocation(MOD_ID, path); }
}
