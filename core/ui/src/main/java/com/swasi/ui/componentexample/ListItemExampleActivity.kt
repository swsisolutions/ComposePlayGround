package com.swasi.ui.componentexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.ui.R

class ListItemExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation(getChatModelList())
        }
    }
}

private fun getChatModelList(): List<ChatModel> {
    val list = mutableListOf<ChatModel>()
    list.add(ChatModel("Name1", "Hello..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(
        ChatModel(
            "Name2",
            "HI..list.add(ChatModel(\"Name2\",\"HI...\"))list.add(ChatModel(\"Name2\",\"HI...\"))list.add(ChatModel(\"Name2\",\"HI...\"))list.add(ChatModel(\"Name2\",\"HI...\"))."
        )
    )
    list.add(ChatModel("Name2", "HI.How are you.."))
    list.add(ChatModel("Name2", "All Good"))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    list.add(ChatModel("Name2", "HI..."))
    return list
}

@Composable
fun Conversation(messages: List<ChatModel>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Composable
fun MessageCard(msg: ChatModel) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.actor1),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Yellow, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.name,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp,
            ) {
                Text(
                    text = msg.message,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

data class ChatModel(val name: String, val message: String)

@Preview
@Composable
fun ListPreview() {
    Conversation(getChatModelList())
}