package com.tooflya.signs.managers;

import android.annotation.TargetApi;
import android.view.View;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdView;
import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.R;
import com.tooflya.signs.screens.Screen;

public class AdvertisementManager {

	private final AdView mSmallAdvertisiment;

	private final AdRequest mAdsRequest;

	private boolean isAdvertisementDisabled = false;

	private boolean isSAdvertisementAvailable = false;
	private boolean isBAdvertisementAvailable = false;

	private final Runnable mShowSmallRunnable = new Runnable() {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			//if (isSAdvertisementAvailable) {
			mSmallAdvertisiment.setVisibility(View.VISIBLE);
			//	}
		}
	};

	private final Runnable mHideSmallRunnable = new Runnable() {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			if (isSAdvertisementAvailable) {
				mSmallAdvertisiment.setVisibility(View.GONE);
			}

			mSmallAdvertisiment.stopLoading();
			mSmallAdvertisiment.loadAd(mAdsRequest);
		}
	};

	/**
	 * 
	 */
	@TargetApi(11)
	public AdvertisementManager() {
		this.mAdsRequest = new AdRequest();
		if (Options.DEBUG) {
			this.mAdsRequest.addTestDevice(AdRequest.TEST_EMULATOR);
			this.mAdsRequest.addTestDevice("75FB804D31DDACC071B1AAF9A074D67A");
			this.mAdsRequest.addTestDevice("2A1EBFDEA347D99BD1F7FBB84433AD72");
			this.mAdsRequest.addTestDevice("FA02AC6CC21C807191ED1A07863CD045");
			this.mAdsRequest.addTestDevice("D964D0EE15FC33E6A1678227284CFA70");
			this.mAdsRequest.addTestDevice("14990D7733B6BBAE1AACFBAEA471130C");
			this.mAdsRequest.setTesting(true);
		}

		this.mSmallAdvertisiment = (AdView) Game.mInstance.findViewById(R.id.adView);

		this.mSmallAdvertisiment.setAdListener(new SmallAdListener());

		this.isAdvertisementDisabled = false;//Game.mDatabase.isAdvertisimentDisabled();

		if (!this.isAdvertisementDisabled()) {
			this.mSmallAdvertisiment.loadAd(this.mAdsRequest);
			Screen.ADS_PADDING = 60f;
		}
	}

	public boolean isAdvertisementDisabled() {
		return false;
		/*	if (Options.DEBUG) {
				return true;
			}

			//return this.isAdvertisementDisabled;
			return true;*/
	}

	public void showSmall() {
		if (!this.isAdvertisementDisabled()) {
			Game.mInstance.runOnUiThread(this.mShowSmallRunnable);
		}
	}

	public void hideSmall() {
		Game.mInstance.runOnUiThread(this.mHideSmallRunnable);
	}

	private final class SmallAdListener implements AdListener {

		/* (non-Javadoc)
		 * @see com.google.ads.AdListener#onDismissScreen(com.google.ads.Ad)
		 */
		@Override
		public void onDismissScreen(Ad arg0) {
		}

		/* (non-Javadoc)
		 * @see com.google.ads.AdListener#onFailedToReceiveAd(com.google.ads.Ad, com.google.ads.AdRequest.ErrorCode)
		 */
		@Override
		public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
			AdvertisementManager.this.isSAdvertisementAvailable = false;
		}

		/* (non-Javadoc)
		 * @see com.google.ads.AdListener#onLeaveApplication(com.google.ads.Ad)
		 */
		@Override
		public void onLeaveApplication(Ad arg0) {
		}

		/* (non-Javadoc)
		 * @see com.google.ads.AdListener#onPresentScreen(com.google.ads.Ad)
		 */
		@Override
		public void onPresentScreen(Ad arg0) {
		}

		/* (non-Javadoc)
		 * @see com.google.ads.AdListener#onReceiveAd(com.google.ads.Ad)
		 */
		@Override
		public void onReceiveAd(Ad arg0) {
			AdvertisementManager.this.isSAdvertisementAvailable = true;
		}
	}
}
