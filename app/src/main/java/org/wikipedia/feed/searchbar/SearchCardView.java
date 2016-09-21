package org.wikipedia.feed.searchbar;

import android.content.Context;
import android.view.View;

import org.wikipedia.R;
import org.wikipedia.feed.view.DefaultFeedCardView;
import org.wikipedia.util.FeedbackUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchCardView extends DefaultFeedCardView<SearchCard> {
    @BindView(R.id.search_container) View searchContainer;
    @BindView(R.id.voice_search_button) View voiceSearchButton;

    public SearchCardView(Context context) {
        super(context);

        inflate(getContext(), R.layout.view_search_bar, this);
        ButterKnife.bind(this);
        FeedbackUtil.setToolbarButtonLongPressToast(voiceSearchButton);

        searchContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCallback() != null) {
                    getCallback().onSearchRequested();
                }
            }
        });

        voiceSearchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCallback() != null) {
                    getCallback().onVoiceSearchRequested();
                }
            }
        });
    }
}