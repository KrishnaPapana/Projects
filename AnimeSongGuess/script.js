document.addEventListener("DOMContentLoaded", function () {
    const startButton = document.getElementById('startButton');
    const gameDiv = document.getElementById('game');
    const introDiv = document.getElementById('intro');
    const playButton = document.getElementById('playButton');
    const song = document.getElementById('song');
    const resultMessage = document.getElementById('resultMessage');
    const replayButton = document.getElementById('replayButton');
    const scoreDisplay = document.createElement('p');
    scoreDisplay.id = 'scoreDisplay';
    scoreDisplay.classList.add('mt-3');
    gameDiv.insertBefore(scoreDisplay, replayButton);

    let songs = []; // Array to hold all songs and answers
    let currentSongIndex = 0;
    let score = 0;

    startButton.addEventListener('click', function () {
        introDiv.classList.add('d-none');
        gameDiv.classList.remove('d-none');
        resetGame();
        loadSongsFromFolder('assets/music/');
    });

    playButton.addEventListener('click', function () {
        song.play();
    });

   

    replayButton.addEventListener('click', function () {
        resetGame();
        loadSongsFromFolder('assets/music/');
        resultMessage.textContent = "";
        guessInput.value = "";
        replayButton.classList.add('d-none');
    });

    function loadSongsFromFolder(folderPath) {
        console.log("2nd called");
        songs = [
            { src: '../AnimeSongGuess/assets/music/Naruto Shippuuden.mp3', answer: 'Naruto Shippuuden', anime: 'Naruto Shippuuden' },
            { src: '../AnimeSongGuess/assets/music/Chainsaw Man.mp3', answer: 'Chainsaw Man', anime: 'Chainsaw Man' }
        ];

        songs = shuffleArray(songs);
        
        if (songs.length > 0) {
            setupGuessOptions();
            nextSong();
        } else {
            alert('No songs found in the folder.');
        }
    }

    function setupGuessOptions() {
        const optionsContainer = document.getElementById('optionsContainer');
        optionsContainer.innerHTML = ''; // Clear previous options
        console.log("3rd called");
       
        const currentSong = songs[currentSongIndex];
        const options = generateRandomOptions(currentSong);
        console.log(options);
        options.forEach(option => {
            const button = document.createElement('button');
            button.textContent = option;
            button.classList.add('btn', 'btn-secondary', 'mr-2', 'mb-2');
            button.addEventListener('click', function () {
                handleGuess(option);
            });
            optionsContainer.appendChild(button);
        });
        
    }

    

    function generateRandomOptions(currentSong) {
        console.log("4th called");
        const options = [currentSong.anime]; 

        // Dummy array of anime names
        const dummyAnimeNames = [
            "Naruto",
            "Attack on Titan",
            "One Piece",
            "My Hero Academia",
            "Sword Art Online",
            "Demon Slayer",
            "Fullmetal Alchemist",
            "Dragon Ball Z",
            "Death Note",
            "Tokyo Ghoul",
            "Hunter x Hunter",
            "One Punch Man",
            "Bleach",
            "Fairy Tail",
            "Neon Genesis Evangelion",
            "Black Clover",
            "Cowboy Bebop",
            "JoJo's Bizarre Adventure",
            "Princess Mononoke",
            "Spirited Away"
        ];

        // Filter out the correct answer and shuffle the remaining options
        const filteredNames = dummyAnimeNames.filter(name => name !== currentSong.anime);
        
        const shuffled = shuffleArray(filteredNames).slice(0, 2);
        options.push(...shuffled);
        console.log(options);
        // Shuffle options array
        
        return shuffleArray(options);
    }

    function shuffleArray(array) {
        
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
        return array;
    }

    function handleGuess(selectedOption) {
        
        const currentSong = songs[currentSongIndex-1];
        
        
        if (selectedOption === currentSong.anime) {
            score++;
            resultMessage.textContent = "Correct! Well done!";
            resultMessage.classList.add('text-success');
            resultMessage.classList.remove('text-danger');
            updateScore();
        } else {
            resultMessage.textContent = "Sorry, that was wrong.";
            resultMessage.classList.add('text-danger');
            resultMessage.classList.remove('text-success');
        }
        setTimeout(nextSong, 2000); // Load next song after 2 seconds
    }

    function nextSong() {
        
        if (currentSongIndex < songs.length) {
            const currentSong = songs[currentSongIndex];
            song.src = currentSong.src;
            setupGuessOptions(); // Setup new guess options
            resultMessage.textContent = ""; // Clear the result message
            currentSongIndex++;
        } else {
            // If all songs have been played
            alert('All songs have been played. Game over!');
            resetGame();
            loadSongsFromFolder('assets/music/');
        }
        
    }

    function updateScore() {
        scoreDisplay.textContent = `kills: ${score}`;
    }

    function resetGame() {
       
        currentSongIndex = 0;
        score = 0;
        updateScore();
        resultMessage.textContent = "";
        replayButton.classList.add('d-none');
       
    }
});
