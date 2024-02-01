package codyhuh.ambientadditions.common;

import codyhuh.ambientadditions.AmbientAdditions;
import codyhuh.ambientadditions.common.entities.*;
import codyhuh.ambientadditions.registry.AAEntities;
import codyhuh.ambientadditions.registry.AAItems;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = AmbientAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(AAEntities.WHITE_FRUIT_BAT.get(), WhiteFruitBat.createAttributes().build());
        event.put(AAEntities.LONGHORN_COWFISH.get(), AbstractFish.createAttributes().build());
        event.put(AAEntities.STAG_BEETLE.get(), StagBeetle.createAttributes().build());
        event.put(AAEntities.NINE_BANDED_ARMADILLO.get(), NineBandedArmadillo.createAttributes().build());
        event.put(AAEntities.VEILED_CHAMELEON.get(), VeiledChameleon.createAttributes().build());
        event.put(AAEntities.MOLE.get(), Mole.createAttributes().build());
        event.put(AAEntities.PEMBROKE_CORGI.get(), PembrokeCorgi.createAttributes().build());
        event.put(AAEntities.CARDIGAN_CORGI.get(), CardiganCorgi.createAttributes().build());
        event.put(AAEntities.NAPOLEON_WRASSE.get(), NapoleonWrasse.createAttributes().build());
        event.put(AAEntities.IIWI.get(), Iiwi.createAttributes().build());
        event.put(AAEntities.PINOCCHIO_ANOLE.get(), PinocchioAnole.createAttributes().build());
        event.put(AAEntities.AYE_AYE.get(), AyeAye.createAttributes().build());
        event.put(AAEntities.SIAMANG_GIBBON.get(), SiamangGibbon.createAttributes().build());
        event.put(AAEntities.RING_TAILED_LEMUR.get(), RingTailedLemur.createAttributes().build());
        event.put(AAEntities.MARTEN.get(), Marten.createAttributes().build());
        event.put(AAEntities.GIANT_LAND_SNAIL.get(), GiantLandSnail.createAttributes().build());
        event.put(AAEntities.CHOCOLATE_CHIP_STARFISH.get(), ChocolateChipStarfish.createAttributes().build());
        event.put(AAEntities.HARLEQUIN_SHRIMP.get(), HarlequinShrimp.createAttributes().build());
        event.put(AAEntities.LEAF_FROG.get(), LeafFrog.createAttributes().build());
        event.put(AAEntities.FLYING_FISH.get(), AbstractFish.createAttributes().build());
        event.put(AAEntities.SHAME_FACED_CRAB.get(), ShameFacedCrab.createAttributes().build());
        event.put(AAEntities.OPAH.get(), Opah.createAttributes().build());
        event.put(AAEntities.BLUNTHEAD_TREE_SNAKE.get(), BluntheadTreeSnake.createAttributes().build());
        event.put(AAEntities.BLUE_SPOTTED_STINGRAY.get(), BlueSpottedStingray.createAttributes().build());
        event.put(AAEntities.LEAF_FROG_TADPOLE.get(), AbstractFish.createAttributes().build());
        event.put(AAEntities.SLOTH_BEAR.get(), SlothBear.createAttributes().build());
    }

    @SubscribeEvent
    public static void spawnPlacements(SpawnPlacementRegisterEvent e) {
        e.register(AAEntities.WHITE_FRUIT_BAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.LEAF_FROG.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.LONGHORN_COWFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.STAG_BEETLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StagBeetle::checkBeetleSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.NINE_BANDED_ARMADILLO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NineBandedArmadillo::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.VEILED_CHAMELEON.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, VeiledChameleon::checkChameleonSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.MOLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mole::checkMoleSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.PEMBROKE_CORGI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.NAPOLEON_WRASSE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.IIWI.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, Iiwi::checkHoneycreeperSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.PINOCCHIO_ANOLE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, PinocchioAnole::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.AYE_AYE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, PinocchioAnole::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.RING_TAILED_LEMUR.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, PinocchioAnole::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.SIAMANG_GIBBON.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, PinocchioAnole::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.MARTEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.CHOCOLATE_CHIP_STARFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, ChocolateChipStarfish::checkStarfishSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.HARLEQUIN_SHRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING, HarlequinShrimp::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.GIANT_LAND_SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.FLYING_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.SHAME_FACED_CRAB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.OPAH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.BLUNTHEAD_TREE_SNAKE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BluntheadTreeSnake::checkSnakeSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.BLUE_SPOTTED_STINGRAY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractFish::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(AAEntities.SLOTH_BEAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}
