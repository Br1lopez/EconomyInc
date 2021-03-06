/*******************************************************************************
 *******************************************************************************/
package fr.fifoube.packets;

import fr.fifoube.main.ModEconomyInc;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketsRegistery {

	public static final String PROTOCOL_VERSION = String.valueOf(1);
	
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(ModEconomyInc.MOD_ID, "packets_ei")).networkProtocolVersion(() -> PROTOCOL_VERSION)
			.clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals).simpleChannel();
	
	public static void registerNetworkPackets() {

		CHANNEL.messageBuilder(PacketListNBT.class, 1).encoder(PacketListNBT::encode).decoder(PacketListNBT::decode).consumer(PacketListNBT::handle).add();
		CHANNEL.messageBuilder(PacketMoneyData.class, 2).encoder(PacketMoneyData::encode).decoder(PacketMoneyData::decode).consumer(PacketMoneyData::handle).add();
		CHANNEL.messageBuilder(PacketSellerCreated.class, 3).encoder(PacketSellerCreated::encode).decoder(PacketSellerCreated::decode).consumer(PacketSellerCreated::handle).add();
		CHANNEL.messageBuilder(PacketSellerFundsTotal.class, 4).encoder(PacketSellerFundsTotal::encode).decoder(PacketSellerFundsTotal::decode).consumer(PacketSellerFundsTotal::handle).add();
		CHANNEL.messageBuilder(PacketCardChangeSeller.class, 5).encoder(PacketCardChangeSeller::encode).decoder(PacketCardChangeSeller::decode).consumer(PacketCardChangeSeller::handle).add();
		CHANNEL.messageBuilder(PacketCardChange.class, 6).encoder(PacketCardChange::encode).decoder(PacketCardChange::decode).consumer(PacketCardChange::handle).add();
		CHANNEL.messageBuilder(PacketChangerUpdate.class, 7).encoder(PacketChangerUpdate::encode).decoder(PacketChangerUpdate::decode).consumer(PacketChangerUpdate::handle).add();

	}



	
}
