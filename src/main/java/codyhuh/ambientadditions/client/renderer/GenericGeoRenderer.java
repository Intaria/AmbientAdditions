package codyhuh.ambientadditions.client.renderer;

import codyhuh.ambientadditions.AmbientAdditions;
import codyhuh.ambientadditions.common.entities.ChocolateChipStarfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.util.AnimationUtils;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public class GenericGeoRenderer<T extends LivingEntity & IAnimatable> extends GeoEntityRenderer<T> {
	private float scale = 1F;

	public GenericGeoRenderer(EntityRendererProvider.Context renderManager, Supplier<AnimatedGeoModel<T>> model) {
		super(renderManager, model.get());
		this.shadowRadius = 0.3F;
	}

	public GenericGeoRenderer(EntityRendererProvider.Context renderManager, Supplier<AnimatedGeoModel<T>> model, float scale) {
		this(renderManager, model.get(), scale);
		this.scale = scale;
	}
	
	public GenericGeoRenderer(EntityRendererProvider.Context mgr, AnimatedGeoModel<T> modelProvider) {
		super(mgr, modelProvider);
	}

	public GenericGeoRenderer(EntityRendererProvider.Context mgr, AnimatedGeoModel<T> modelProvider, float scale) {
		this(mgr, modelProvider);
		this.scale = scale;
	}
	
	@Override
	public void render(T entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
		if (scale != 1F) {
			stack.scale(scale, scale, scale);
		}

		if (entity instanceof AgeableMob mob && mob.isBaby()) {
			stack.scale(0.5F, 0.5F, 0.5F);
		}

		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}

	@Override
	public void renderEarly(T animatable, PoseStack poseStack, float partialTick, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float partialTicks) {
		if (animatable instanceof ChocolateChipStarfish starfish) {
			GeoModel model = AnimationUtils.getGeoModelForEntity(starfish).getModel(new ResourceLocation(AmbientAdditions.MOD_ID, "geo/entity/chocolate_chip_starfish.geo.json"));

			for (int i = 1; i <= 5; i++) {
				Optional<GeoBone> arm = model.getBone("Arm" + i);
				arm.ifPresent(geoBone -> geoBone.setHidden(true));
			}

			for (int i = 1; i <= (int) starfish.getHealth(); i++) {
				Optional<GeoBone> arm = model.getBone("Arm" + i);

				arm.ifPresent(geoBone -> geoBone.setHidden(false));
			}

		}

		super.renderEarly(animatable, poseStack, partialTick, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, partialTicks);
	}

	@Override
	public RenderType getRenderType(T animatable, float partialTick, PoseStack poseStack, @org.jetbrains.annotations.Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(texture);
	}
}