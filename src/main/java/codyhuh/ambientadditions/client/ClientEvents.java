package codyhuh.ambientadditions.client;

import codyhuh.ambientadditions.AmbientAdditions;
import codyhuh.ambientadditions.client.model.GenericGeoModel;
import codyhuh.ambientadditions.client.model.TextureVariantModel;
import codyhuh.ambientadditions.client.particles.StunParticle;
import codyhuh.ambientadditions.client.particles.ZzzParticle;
import codyhuh.ambientadditions.client.renderer.GenericGeoRenderer;
import codyhuh.ambientadditions.client.renderer.item.DuckyMaskRenderer;
import codyhuh.ambientadditions.client.renderer.layer.AAGlowingEyesLayer;
import codyhuh.ambientadditions.client.renderer.layer.ChameleonBrightnessLayer;
import codyhuh.ambientadditions.common.entities.*;
import codyhuh.ambientadditions.common.items.DuckyMaskItem;
import codyhuh.ambientadditions.registry.AAEntities;
import codyhuh.ambientadditions.registry.AAItems;
import codyhuh.ambientadditions.registry.AAParticles;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.ArrayList;
import java.util.Arrays;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AmbientAdditions.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    private static void make(EntityType type, String name){
        EntityRenderers.register(type, (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>(name)));
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityType<?>[] simpleEntities = new EntityType[]{
                AAEntities.GIANT_LAND_SNAIL.get(), AAEntities.LONGHORN_COWFISH.get(), AAEntities.NINE_BANDED_ARMADILLO.get(),
                AAEntities.IIWI.get(), AAEntities.PINOCCHIO_ANOLE.get(),
                AAEntities.MARTEN.get(), AAEntities.RING_TAILED_LEMUR.get(),
                AAEntities.STAG_BEETLE.get(), AAEntities.SHAME_FACED_CRAB.get(),
                AAEntities.FLYING_FISH.get(), AAEntities.NAPOLEON_WRASSE.get(), AAEntities.OPAH.get(),
                AAEntities.BLUNTHEAD_TREE_SNAKE.get(), AAEntities.BLUE_SPOTTED_STINGRAY.get(), AAEntities.LEAF_FROG_TADPOLE.get(), AAEntities.LEAF_FROG.get(),

        };
        for (EntityType<?> type : simpleEntities) {
            make(type, type.getDescriptionId().substring("entity.ambientadditions.".length()));
        }

        EntityRenderers.register(AAEntities.AYE_AYE.get(), (ctx) -> {
            GenericGeoRenderer<AyeAye> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("aye_aye"));
            render.addLayer(new AAGlowingEyesLayer<>("aye_aye", render));
            return render;
        });

        EntityRenderers.register(AAEntities.VEILED_CHAMELEON.get(), (ctx) -> {
            GenericGeoRenderer<VeiledChameleon> render = new GenericGeoRenderer<>(ctx, () -> {
                TextureVariantModel<VeiledChameleon> model = new TextureVariantModel<>("veiled_chameleon");
                ArrayList<ResourceLocation> textures = new ArrayList<>();
                for (int i=1;i<=7;i++){
                    textures.add(new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/veiled_chameleon/veiled_chameleon_" + i + ".png"));
                }
                model.setTextures(VeiledChameleon::getVariant, textures);
                return model;
            });
            render.addLayer(new ChameleonBrightnessLayer(render));
            return render;
        });

        EntityRenderers.register(AAEntities.CHOCOLATE_CHIP_STARFISH.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<ChocolateChipStarfish> model = new TextureVariantModel<>("chocolate_chip_starfish");
            ArrayList<ResourceLocation> textures = new ArrayList<>();
            for (int i=1;i<=5;i++){
                textures.add(new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/chocolate_chip_starfish/starfish_" + i + ".png"));
            }
            model.setTextures(ChocolateChipStarfish::getVariant, textures);
            return model;
        }));

        EntityRenderers.register(AAEntities.HARLEQUIN_SHRIMP.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<HarlequinShrimp> model = new TextureVariantModel<>("harlequin_shrimp");
            model.setTextures(HarlequinShrimp::getVariant, Arrays.asList(
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/harlequin_shrimp/pink.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/harlequin_shrimp/purple.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/harlequin_shrimp/blue.png")
            ));
            return model;
        }));

        EntityRenderers.register(AAEntities.MOLE.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<Mole> model = new TextureVariantModel<>("star_nosed_mole");
            model.setTextures(Mole::getVariant, Arrays.asList(
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/mole/star_nosed_mole.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/mole/eastern_mole.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/mole/hairy_tailed_mole.png")
            ));
            return model;
        }));

        EntityRenderers.register(AAEntities.SIAMANG_GIBBON.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<SiamangGibbon> model = new TextureVariantModel<>("siamang_gibbon");
            model.setTextures((e) -> e.isBooming() ? 1 : 0, Arrays.asList(
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/siamang_gibbon/normal.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/siamang_gibbon/booming.png")
            ));
            return model;
        }));

        EntityRenderers.register(AAEntities.WHITE_FRUIT_BAT.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<WhiteFruitBat> model = new TextureVariantModel<>("white_fruit_bat");
            model.setTextures((e) -> e.isResting() ? 1 : 0, Arrays.asList(
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/white_fruit_bat/bat.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/white_fruit_bat/resting.png")
            ));
            return model;
        }) {

            @Override
            protected void applyRotations(WhiteFruitBat entitylivingbaseIn, PoseStack matrix, float ageInTicks, float rotationYaw, float partialTicks) {
                super.applyRotations(entitylivingbaseIn, matrix, ageInTicks, rotationYaw, partialTicks);
                matrix.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entitylivingbaseIn.prevTilt, entitylivingbaseIn.tilt)));
            }
        });

        EntityRenderers.register(AAEntities.SLOTH_BEAR.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> {
            TextureVariantModel<SlothBear> model = new TextureVariantModel<>("sloth_bear");
            model.setTextures((e) -> e.isAngry() ? 1 : 0, Arrays.asList(
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/sloth_bear/bear.png"),
                    new ResourceLocation(AmbientAdditions.MOD_ID, "textures/entity/sloth_bear/angry.png")
            ));
            return model;
        }));

        AmbientAdditions.CALLBACKS.forEach(Runnable::run);
        AmbientAdditions.CALLBACKS.clear();

        GeoArmorRenderer.registerArmorRenderer(DuckyMaskItem.class, DuckyMaskRenderer::new);

    }

    @SubscribeEvent
    public static void registerParticleTypes(RegisterParticleProvidersEvent event) {
        event.register(AAParticles.ZZZ.get(), ZzzParticle.Provider::new);
        event.register(AAParticles.STUN.get(), StunParticle.Provider::new);
    }
}