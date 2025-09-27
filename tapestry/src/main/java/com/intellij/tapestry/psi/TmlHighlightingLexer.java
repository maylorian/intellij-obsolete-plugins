package com.intellij.tapestry.psi;

import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * @author Alexey Chmutov
 */
public class TmlHighlightingLexer extends TmlLexer {

	private static final TokenSet CUSTOM_ATTRIBUTE_TOKENS = TokenSet.create(TelTokenTypes.TAP5_EL_CONTENT);

	public TmlHighlightingLexer() {
		super();
	}

	protected @NotNull TokenSet createAttributeEmbedmentTokenSet() {
		return CUSTOM_ATTRIBUTE_TOKENS;
	}
}

